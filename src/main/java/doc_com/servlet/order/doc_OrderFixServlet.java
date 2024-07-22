package doc_com.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.OrderDao;

/**
 * Servlet implementation class doc_OrderFixServlet
 */
@WebServlet("/doc_OrderFixServlet")
public class doc_OrderFixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doc_OrderFixServlet() {
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
		String uid2 = request.getParameter("uid");
		String oresult = request.getParameter("oresult");
		String omedicine = request.getParameter("omedicine");
		String omoney2 = request.getParameter("omoney");

		boolean sta=false;
		
		if(oid2.equals("")||otime.equals("")||uid2.equals("")||oresult.equals("")||omedicine.equals("")||omoney2.equals("")) {
			request.getSession().setAttribute("sta","修改订单失败，请检查表单是否填写完整");
		}else {
		int oid = Integer.parseInt(oid2);
		int uid = Integer.parseInt(uid2);
		double omoney = Double.parseDouble(omoney2);
		sta = OrderDao.fix(otime, uid, oresult, omedicine, omoney, oid);
		}
		
		if(sta==true){
			request.getSession().setAttribute("sta", "修改成功");
		}
		response.sendRedirect("/Hospital/doctor_order.jsp");
	}
}
