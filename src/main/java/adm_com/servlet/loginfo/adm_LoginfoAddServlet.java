package adm_com.servlet.loginfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.LoginfoDao;

/**
 * Servlet implementation class adm_LoginfoAddServlet
 */
@WebServlet("/adm_LoginfoAddServlet")
public class adm_LoginfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_LoginfoAddServlet() {
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
		String lname = request.getParameter("lname");
		String ltime = request.getParameter("ltime");
		int lid = Integer.parseInt(lid2);

		boolean sta = LoginfoDao.add(lid, lname, ltime);
		if(sta==true){
			request.getSession().setAttribute("sta", "添加成功");
			response.sendRedirect("/Hospital/adm_loginfo.jsp");
		}else {
			request.getSession().setAttribute("sta", "添加失败");
			response.sendRedirect("/Hospital/adm_loginfo.jsp");
		}
	}

}
