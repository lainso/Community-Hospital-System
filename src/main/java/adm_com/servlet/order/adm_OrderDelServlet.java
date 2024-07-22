package adm_com.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.OrderDao;

/**
 * Servlet implementation class adm_OrderDelServlet
 */
@WebServlet("/adm_OrderDelServlet")
public class adm_OrderDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_OrderDelServlet() {
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

		String oid2 = request.getParameter("oid");
		int oid = Integer.parseInt(oid2);

		boolean sta = OrderDao.delete(oid);
		if(sta==true){
			request.getSession().setAttribute("sta", "删除成功");
			response.sendRedirect("/Hospital/adm_order.jsp");
		}else {
			request.getSession().setAttribute("sta", "删除失败");
			response.sendRedirect("/Hospital/adm_order.jsp");
		}
	}

}
