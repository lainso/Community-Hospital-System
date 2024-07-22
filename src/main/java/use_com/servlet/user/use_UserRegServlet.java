package use_com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import use_com.dao.UserDao;

/**
 * Servlet implementation class use_UserRegServlet
 */
@WebServlet("/use_UserRegServlet")
public class use_UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public use_UserRegServlet() {
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
		String uname = request.getParameter("uname");
		String usex = request.getParameter("usex");
		String uage2 = request.getParameter("uage");
		String utel2 = request.getParameter("utel");
		
		int uid = Integer.parseInt(uid2);
		int uage = Integer.parseInt(uage2);
		double utel = Double.parseDouble(utel2);
		
		
		boolean a = UserDao.regist(uid,upass,uname,usex,uage,utel);
		
		//a==true表明注册成功
		//a==false表明注册失败
		
		if(a==true) {
			request.getSession().setAttribute("sta","注册账号成功");
			response.sendRedirect("/Hospital/jsp/user/login.jsp");		
		}else {
			request.getSession().setAttribute("sta","注册账号失败");
			response.sendRedirect("/Hospital/jsp/user/register.jsp");
		}
	}

}
