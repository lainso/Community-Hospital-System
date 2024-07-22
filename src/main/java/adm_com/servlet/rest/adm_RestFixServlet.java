package adm_com.servlet.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.restDao;

/**
 * Servlet implementation class adm_RestFixServlet
 */
@WebServlet("/adm_RestFixServlet")
public class adm_RestFixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_RestFixServlet() {
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
		
		
		//获取药品信息
				String rid2 = request.getParameter("rid");
				String did2 = request.getParameter("did");
				String rreason = request.getParameter("rreason");
				String rstart = request.getParameter("rstart");
				String rend = request.getParameter("rend");
				String rcondition2 = request.getParameter("rcondition");
				
				int rid = Integer.parseInt(rid2);
				int did = Integer.parseInt(did2);
				int rcondition = Integer.parseInt(rcondition2);
		
		boolean a = restDao.chanage(rid,did,rreason,rstart,rend,rcondition);
		
		if(a==true) {
			request.getSession().setAttribute("ch","修改成功");
			response.sendRedirect("/Hospital/adm_rest.jsp");		
		}else {
			request.getSession().setAttribute("ch","修改失败");
			response.sendRedirect("/Hospital/adm_rest.jsp");
		}
	}

}
