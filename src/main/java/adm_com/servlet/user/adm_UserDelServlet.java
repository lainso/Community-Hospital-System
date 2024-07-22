package adm_com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.UserDao;

/**
 * Servlet implementation class adm_UserDelServlet
 */
@WebServlet("/adm_UserDelServlet")
public class adm_UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_UserDelServlet() {
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
//		String uid2 = request.getParameter("uid2");
		int uid2 = Integer.parseInt(request.getParameter("uid2"));
		
//		int uid = Integer.parseInt(uid2);
		
		boolean ch = UserDao.delete(uid2);
		
		//ch==true表明修改成功
		//ch==false表明修改失败
		
		if(ch==true) {
			request.getSession().setAttribute("ch","信息删除成功");
			response.sendRedirect(request.getContextPath()+"/adm_user.jsp");		
		}else {
			
			request.getSession().setAttribute("ch","信息删除失败,请重试");
			response.sendRedirect(request.getContextPath()+"/adm_user.jsp");
		}
	}

}
