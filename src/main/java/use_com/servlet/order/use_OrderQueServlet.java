package use_com.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import use_com.dao.OrderDao;
import use_com.model.Order;

/**
 * Servlet implementation class use_OrderQueServlet
 */
@WebServlet("/use_OrderQueServlet")
public class use_OrderQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public use_OrderQueServlet() {
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

		String uid2 = request.getParameter("uid");
		
		ArrayList<Order> a;
		if(uid2.equals("")) {
			a = OrderDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			int uid = Integer.parseInt(uid2);
			a = OrderDao.getList(uid);
			request.getSession().setAttribute("sta", "查询成功");
		}
		request.getSession().setAttribute("orderlist",a);
		response.sendRedirect("/Hospital/jsp/user/index.jsp");
	}

}
