package use_com.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import use_com.dao.UserDao;
import use_com.model.User;

/**
 * Servlet implementation class use_UserQueServlet
 */
@WebServlet("/use_UserQueServlet")
public class use_UserQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public use_UserQueServlet() {
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
		
		
		//获取查询信息
		String uid = request.getParameter("uid3");
		
		
		
		ArrayList<User> a;
		
		if(uid.equals("")) {
			a = UserDao.get_List();
			request.getSession().setAttribute("ch","信息查询成功");
		}else {
			a = UserDao.get_List(uid);
			request.getSession().setAttribute("ch","信息查询失败,请重试");
		}
		
		request.getSession().setAttribute("usermessage", a);
			
		response.sendRedirect("/Hospital/jsp/user/my.jsp");
		
	}

}
