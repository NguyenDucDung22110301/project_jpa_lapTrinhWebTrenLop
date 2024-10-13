package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Util.Constant;

/**
 * Servlet implementation class uploadFile
 */
@WebServlet(
		 urlPatterns = {"/viewCustomer/multiPartServlet"}
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
 maxFileSize = 1024 * 1024 * 5, 
 maxRequestSize = 1024 * 1024 * 5 * 5)
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String getFileName(Part part) {
    	 for (String content : part.getHeader("content-disposition").split(";")) {
    	 if (content.trim().startsWith("filename"))
    		 return content.substring(content.indexOf("=") + 2, content.length() - 1);
    	 }
    	 	return Constant.DEFAULT_FILENAME;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = File.separator + Constant.UPLOAD_DIRECTORY;
		 File uploadDir = new File(uploadPath);
		 if (!uploadDir.exists())
			 uploadDir.mkdir();
		 try {
			 String fileName = "";
			 for (Part part : request.getParts()) {
			 fileName = getFileName(part);
			 part.write(uploadPath + File.separator + fileName);
		 }
			 request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
			 getServletContext().getRequestDispatcher("/viewCustomer/updateAvatar.jsp").forward(request, response);
		 } catch (FileNotFoundException fne) {
			 request.setAttribute("message", "There was an error: " + fne.getMessage());
		 }
	}

}
