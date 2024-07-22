package adm_com.servlet.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.restDao;

/**
 * Servlet implementation class adm_RestDelServlet
 */
@WebServlet("/adm_RestDelServlet")
public class adm_RestDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_RestDelServlet() {
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
		String rid2 = request.getParameter("rid");
		
		int rid = Integer.parseInt(rid2);
		
		boolean ch = restDao.delete(rid);
		
		if(ch==true) {
			request.getSession().setAttribute("ch","信息删除成功");
			response.sendRedirect("/Hospital/adm_rest.jsp");		
		}else {
			
			request.getSession().setAttribute("ch","信息删除失败,请重试");
			response.sendRedirect("/Hospital/adm_rest.jsp");
		}
	}

}
