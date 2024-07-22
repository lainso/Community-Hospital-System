package adm_com.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.GoodsDao;

/**
 * Servlet implementation class adm_GoodsAddServlet
 */
@WebServlet("/adm_GoodsAddServlet")
public class adm_GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_GoodsAddServlet() {
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
		String gname = request.getParameter("gname");
		String gnum2 = request.getParameter("gnum");
		String gprice2 = request.getParameter("gprice");
		
		int gid = Integer.parseInt(gid2);
		int gnum = Integer.parseInt(gnum2);
		double gprice = Double.parseDouble(gprice2);
		

		boolean sta = GoodsDao.add(gid, gname, gnum, gprice);
		if(sta==true){
			request.getSession().setAttribute("sta", "添加成功");
			response.sendRedirect("/Hospital/adm_goods.jsp");
		}else {
			request.getSession().setAttribute("sta", "添加失败");
			response.sendRedirect("/Hospital/adm_goods.jsp");
		}
	}

}
