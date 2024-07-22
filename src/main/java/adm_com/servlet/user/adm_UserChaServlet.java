package adm_com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.UserDao;

/**
 * Servlet implementation class adm_UserChaServlet
 */
@WebServlet("/adm_UserChaServlet")
public class adm_UserChaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_UserChaServlet() {
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
		
		
		//获取修改信息
		String uid2 = request.getParameter("uid");
		String upass = request.getParameter("upass");
		String uname = request.getParameter("uname");
		String usex = request.getParameter("usex");
		String uage2 = request.getParameter("uage");
		String utel2 = request.getParameter("utel");
		String ucondition2 = request.getParameter("ucondition");
		String udescripe = request.getParameter("udescripe");
		
		
		int uid = Integer.parseInt(uid2);
		int uage = Integer.parseInt(uage2);
		double utel = Double.parseDouble(utel2);
		int ucondition = Integer.parseInt(ucondition2);
		
		boolean ch = UserDao.chanage(uid,upass,uname,usex,uage,utel,ucondition,udescripe);
		
		//ch==true表明修改成功
		//ch==false表明修改失败
		
		if(ch==true) {
			request.getSession().setAttribute("ch","信息修改成功");
			response.sendRedirect(request.getContextPath()+"/adm_user.jsp");		
		}else {
			
			request.getSession().setAttribute("ch","信息修改失败,请填写完整其他信息");
			response.sendRedirect(request.getContextPath()+"/adm_user.jsp");
		}
	}

}
