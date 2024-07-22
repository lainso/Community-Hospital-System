package adm_com.servlet.loginfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.LoginfoDao;

/**
 * Servlet implementation class adm_LoginfoDelServlet
 */
@WebServlet("/adm_LoginfoDelServlet")
public class adm_LoginfoDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_LoginfoDelServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String lid2 = request.getParameter("lid");
		int lid = Integer.parseInt(lid2);

		boolean sta = LoginfoDao.delete(lid);
		if(sta==true){
			request.getSession().setAttribute("sta", "删除成功");
			response.sendRedirect("/Hospital/adm_loginfo.jsp");
		}else {
			request.getSession().setAttribute("sta", "删除失败");
			response.sendRedirect("/Hospital/adm_loginfo.jsp");
		}
	}

}
