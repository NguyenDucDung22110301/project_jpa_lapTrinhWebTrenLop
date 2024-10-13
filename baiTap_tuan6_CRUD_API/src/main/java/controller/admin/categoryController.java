package controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import Util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.categoryModel;
import service.IcategoryService;
import service.impl.categoryServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns =  {"/admin/categories", "/admin/category/add","/admin/category/insert",
								"/admin/category/edit","/admin/category/update","/admin/category/delete", "/admin/category/seach"})
public class categoryController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public IcategoryService cateSer = new categoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url  = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("categories")) {
			List<categoryModel> list = cateSer.findALL();
			req.setAttribute("listcase", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("add")){
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")){
			String id = req.getParameter("id");
			int Id = Integer.parseInt(id);
			categoryModel cate = cateSer.findById(Id);
			req.setAttribute("cate", cate);
			
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}else if(url.contains("delete")){
			int categoryId = Integer.parseInt(req.getParameter("id"));
			cateSer.delete(categoryId);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url  = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("insert")) {
			String categoryName = req.getParameter("categoryName");
			String status = req.getParameter("status");
			categoryModel ct = new categoryModel();
			ct.setCategoryName(categoryName);
			int statuss = Integer.parseInt(status);
			ct.setStatus(statuss);
			
			String frame = "";
			String uploadPath = Constant.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if(part.getSize()>0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index+ 1);
					frame = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + File.separator + frame);
					ct.setImages(frame);
				}
				else {
					ct.setImages("app-store.jpg");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			cateSer.insert(ct);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}else if(url.contains("update")) {
			int categoryId = Integer.parseInt(req.getParameter("categoryId"));
			String categoryName = req.getParameter("categoryName");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			String img = "https://www.vietnamworks.com/hrinsider/wp-content/uploads/2023/12/hinh-anh-thien-nhien-3d-dep-006.jpg";
			categoryModel ct = new categoryModel();
			ct.setCategoryId(categoryId);
			ct.setCategoryName(categoryName);
			ct.setStatus(statuss);
			ct.setImages(img);
			cateSer.update(ct);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
