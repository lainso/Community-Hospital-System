package adm_com.servlet.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.GoodsDao;
import adm_com.model.Goods;

/**
 * Servlet implementation class adm_GoodsQueServlet
 */
@WebServlet("/adm_GoodsQueServlet")
public class adm_GoodsQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_GoodsQueServlet() {
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

		String gid2 = request.getParameter("gid");
		
		ArrayList<Goods> a;
		if(gid2.equals("")) {
			a = GoodsDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			int gid = Integer.parseInt(gid2);
			a = GoodsDao.getList(gid);
			request.getSession().setAttribute("sta", "查询成功");
		}
		request.getSession().setAttribute("goodslist",a);
		response.sendRedirect("/Hospital/adm_goods.jsp");
	}

}
