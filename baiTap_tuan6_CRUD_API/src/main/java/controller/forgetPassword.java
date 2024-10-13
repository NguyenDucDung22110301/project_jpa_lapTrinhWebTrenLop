package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class forgetPassword
 */



public class forgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		UserServiceImpl us = new UserServiceImpl();
		User user = us.get(username);
		String alertMsg = null;
		if(user != null) {
			if(!us.compUser(user.getEmail(), email)) {
				alertMsg = " email không đúng với email đã đăng kí! ";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("viewCustomer/forgetPass.jsp").forward(request, response);
			}else if(!us.compUser(password, repassword)) {
				alertMsg = " mật khẩu nhập lại không đúng ";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("viewCustomer/forgetPass.jsp").forward(request, response);
			}else {
				us.changePassword(username, password);
				alertMsg = " đổi mật khẩu thành công, vui lòng quay lại đăng nhập ";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("viewCustomer/forgetPass.jsp").forward(request, response);
			}
		}else {
			alertMsg = "chưa tồn tại khách hàng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/forgetPass.jsp").forward(request, response);
		}
		
	}

}
