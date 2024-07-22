package doc_com.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.OrderDao;
import doc_com.model.Order;

/**
 * Servlet implementation class doc_OrderQueServlet
 */
@WebServlet("/doc_OrderQueServlet")
public class doc_OrderQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doc_OrderQueServlet() {
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
		
		ArrayList<Order> a;
		if(oid2.equals("")) {
			a = OrderDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			int oid = Integer.parseInt(oid2);
			a = OrderDao.getList(oid);
			request.getSession().setAttribute("sta", "查询成功");
		}
		request.getSession().setAttribute("orderlist",a);
		response.sendRedirect("/Hospital/doctor_order.jsp");
	}

}
