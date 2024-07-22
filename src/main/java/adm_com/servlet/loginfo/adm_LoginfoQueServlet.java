package adm_com.servlet.loginfo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.LoginfoDao;
import adm_com.model.Loginfo;

/**
 * Servlet implementation class adm_LoginfoQueServlet
 */
@WebServlet("/adm_LoginfoQueServlet")
public class adm_LoginfoQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_LoginfoQueServlet() {
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
		
		ArrayList<Loginfo> a;
		if(lid2.equals("")) {
			a = LoginfoDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			int lid = Integer.parseInt(lid2);
			a = LoginfoDao.getList(lid);
			request.getSession().setAttribute("sta", "查询失败");
		}
		request.getSession().setAttribute("infolist",a);
		response.sendRedirect("/Hospital/adm_loginfo.jsp");
	}

}
