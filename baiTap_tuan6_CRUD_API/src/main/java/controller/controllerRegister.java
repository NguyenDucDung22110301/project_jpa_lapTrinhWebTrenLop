package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;

import Util.Constant;



/**
 * Servlet implementation class controllerRegister
 */
@WebServlet (urlPatterns ={"/viewCustomer/Register"})
public class controllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
			 if (cookie.getName().equals("username")) {
				session = request.getSession(true);
				session.setAttribute("username", cookie.getValue());
				response.sendRedirect(request.getContextPath() + "/admin");
				return;
			 }
		}
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		UserService service = new UserServiceImpl();
		String alertMsg ="";
		if (service.checkExistEmail(email)) {
				alertMsg = "Email đã tồn tại!";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
				return;
		}
		if (service.checkExistUsername(username)) {
				alertMsg = "Tài khoản đã tồn tại!";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
				return;
		}
		boolean isSuccess = service.register(username, password, email, fullname, phone);
		if (isSuccess) {
				//SendMail sm = new SendMail();
				//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
					request.setAttribute("alert", alertMsg);
					response.sendRedirect(request.getContextPath() + "viewCustomer/registerSuccess.jsp");
				} else {
					alertMsg = "System error!";
					request.setAttribute("alert", alertMsg);
					request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
				}
			}
}
