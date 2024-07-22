package use_com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import use_com.dao.UserDao;

/**
 * Servlet implementation class use_UserLogServlet
 */
@WebServlet("/use_UserLogServlet")
public class use_UserLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public use_UserLogServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//获取注册信息
		String uid2 = request.getParameter("uid");
		String upass = request.getParameter("upass");
		
		int uid = Integer.parseInt(uid2);
		boolean a = UserDao.login(uid,upass);
		
		//a==true表明注册成功
		//a==false表明注册失败
		
		if(a==true) {
			response.sendRedirect("/Hospital/jsp/user/index.jsp");
			request.getSession().setAttribute("uid",uid2);
		}else {
			request.getSession().setAttribute("sta","账号或者密码错误");
			response.sendRedirect("/Hospital/jsp/user/login.jsp");
		}
	}

}
