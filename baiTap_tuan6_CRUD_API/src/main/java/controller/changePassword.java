package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.impl.UserServiceImpl;

import java.io.IOException;


/**
 * Servlet implementation class changePassword
 */
@WebServlet (urlPatterns ={"/viewCustomer/changePass"})
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath()+ "/index.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("oldpassword");
		String repassword = request.getParameter("repassword");
		String newrepassword = request.getParameter("newrepassword");
		
		String username = "";
		String alertMsg ="";
		HttpSession ses = request.getSession();
		Object obj = (Object)ses.getAttribute("account");
		User user = null;
		UserServiceImpl service = new UserServiceImpl();
		if(obj != null) {
			user = (User)obj;
			username = user.getUserName() + "";
		}
		if(user == null) {
			alertMsg = "chưa tồn tại khách hàng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/ChangePass.jsp").forward(request, response);
		}
		if(password.equals(user.getPassWord())){
			if(password.equals(repassword)) {
				alertMsg = "Mật khẩu mới không được giống mật khẩu cũ";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/viewCustomer/ChangePass.jsp").forward(request, response);
			}else {
				if(repassword.equals(newrepassword)) {
					System.out.println("thay doi mat khau thanh cong");
					service.changePassword(username, repassword);
					request.getRequestDispatcher("/viewCustomer/successChangePass.jsp").forward(request, response);
				}else {
					alertMsg = "Mật khẩu nhập lại không khớp";
					request.setAttribute("alert", alertMsg);
					request.getRequestDispatcher("/viewCustomer/ChangePass.jsp").forward(request, response);
				}
			}
			alertMsg = "Mật khẩu hiện tại không khớp với mật khẩu cũ";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/ChangePass.jsp").forward(request, response);
		}else {
			alertMsg = "Mật khẩu hiện tại không khớp với mật khẩu cũ";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/ChangePass.jsp").forward(request, response);
		}
		
	}

}
