package controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import Util.Constant;
import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.ICategoryService;
import service.impl.categoryService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns =  {"/admin/categories", "/admin/category/add","/admin/category/insert",
								"/admin/category/edit","/admin/category/update","/admin/category/delete", "/admin/category/seach"})
public class categoryController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ICategoryService cateSer = new categoryService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url  = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("categories")) {
			 List<Category> list = cateSer.findAll();
			req.setAttribute("listcase", list);
			req.getRequestDispatcher("/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("add")){
			req.getRequestDispatcher("/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")){
			String id = req.getParameter("id");
			int Id = Integer.parseInt(id);
			Category cate = cateSer.findById(Id);
			req.setAttribute("cate", cate);
			
			req.getRequestDispatcher("/admin/category-edit.jsp").forward(req, resp);
		}else if(url.contains("delete")){
			int categoryId = Integer.parseInt(req.getParameter("id"));
			try {
				cateSer.delete(categoryId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url  = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("insert")) {
			String categoryName = req.getParameter("categoryname");
			String status = req.getParameter("status");
			Category ct = new Category();
			ct.setCategoryname(categoryName);
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
			String categoryName = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			String img = "https://www.vietnamworks.com/hrinsider/wp-content/uploads/2023/12/hinh-anh-thien-nhien-3d-dep-006.jpg";
			Category ct = new Category();
			ct.setCategoryId(categoryId);
			ct.setCategoryname(categoryName);
			ct.setStatus(statuss);
			ct.setImages(img);
			cateSer.update(ct);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
