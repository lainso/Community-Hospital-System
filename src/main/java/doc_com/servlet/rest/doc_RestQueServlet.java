package doc_com.servlet.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.restDao;
import doc_com.model.Rest;

/**
 * Servlet implementation class doc_RestQueServlet
 */
@WebServlet("/doc_RestQueServlet")
public class doc_RestQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doc_RestQueServlet() {
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
		String rid = request.getParameter("rid");
		
		
		ArrayList<Rest> a;
		
		if(rid.equals("")) {
			a = restDao.get_List();
			request.getSession().setAttribute("ch","信息查询成功");
		}else {
			a = restDao.get_List(rid);
			request.getSession().setAttribute("ch","信息查询成功");
		}		
		
		request.getSession().setAttribute("usermessage", a);
			
		response.sendRedirect("/Hospital/doctor_rest.jsp");	
	}

}
