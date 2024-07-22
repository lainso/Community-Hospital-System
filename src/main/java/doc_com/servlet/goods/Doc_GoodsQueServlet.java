package doc_com.servlet.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.GoodsDao;
import doc_com.model.Goods;

/**
 * Servlet implementation class Doc_GoodsQueServlet
 */
@WebServlet("/Doc_GoodsQueServlet")
public class Doc_GoodsQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doc_GoodsQueServlet() {
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

		String gname = request.getParameter("gname");
		
		ArrayList<Goods> a;
		if(gname.equals("")) {
			a = GoodsDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			a = GoodsDao.getList1(gname);
			request.getSession().setAttribute("sta", "查询成功");
		}
		request.getSession().setAttribute("goodslist",a);
		response.sendRedirect("/Hospital/doctor_goods.jsp");
	}

}
