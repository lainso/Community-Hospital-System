package use_com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import use_com.dao.UserDao;

/**
 * Servlet implementation class use_UserDelServlet
 */
@WebServlet("/use_UserDelServlet")
public class use_UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public use_UserDelServlet() {
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
		
		
		//获取删除信息
		String uid2 = request.getParameter("uid2");
		
		int uid = Integer.parseInt(uid2);
		
		boolean ch = UserDao.delete(uid);
		
		//ch==true表明修改成功
		//ch==false表明修改失败
		
		if(ch==true) {
			request.getSession().setAttribute("ch","信息删除成功");
			response.sendRedirect("/Hospital/jsp/user/login.jsp");		
		}else {
			
			request.getSession().setAttribute("ch","信息删除失败,请重试");
			response.sendRedirect("/Hospital/jsp/user/my.jsp");
		}
	}

}
