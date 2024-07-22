package adm_com.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.OrderDao;

/**
 * Servlet implementation class adm_OrderAddServlet
 */
@WebServlet("/adm_OrderAddServlet")
public class adm_OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_OrderAddServlet() {
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
		String otime = request.getParameter("otime");
		String did2 = request.getParameter("did");
		String uid2 = request.getParameter("uid");
		String oresult = request.getParameter("oresult");
		String omedicine = request.getParameter("omedicine");
		String omoney2 = request.getParameter("omoney");

		int oid = Integer.parseInt(oid2);
		int did = Integer.parseInt(did2);
		int uid = Integer.parseInt(uid2);
		double omoney = Double.parseDouble(omoney2);

		boolean sta = OrderDao.add(oid, otime, did, uid, oresult, omedicine, omoney);
		if(sta==true){
			request.getSession().setAttribute("sta", "创建订单成功");
			response.sendRedirect("/Hospital/adm_order.jsp");
		}else {
			request.getSession().setAttribute("sta", "创建订单失败");
			response.sendRedirect("/Hospital/adm_order.jsp");
		}
	}

}
