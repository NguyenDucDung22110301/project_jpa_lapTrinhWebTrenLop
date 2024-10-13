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

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;


/**
 * Servlet implementation class changeInfor
 */
@WebServlet (urlPatterns ={"/viewCustomer/changeinfor"})
public class changeInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeInfor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath()+ "/index.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		
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
			request.getRequestDispatcher("/viewCustomer/informationCustommer.jsp").forward(request, response);
		}
		if(!fullname.equals(user.getFullName())){
			service.changeName(username, fullname);
		}
		if(!phone.equals(user.getPhone())) {
			service.changePhone(username, phone);;
		}
		
		if (fullname.equals(user.getFullName()) && phone.equals(user.getPhone())) {
			alertMsg = "Thông tin đã trùng với thông tin cũ";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/informationCustommer.jsp").forward(request, response);
		}else {
			alertMsg = "Thông tin đã được thay đổi";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/viewCustomer/informationCustommer.jsp").forward(request, response);
		}
		
	}

}
