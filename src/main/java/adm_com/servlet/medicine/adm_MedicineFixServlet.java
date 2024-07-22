package adm_com.servlet.medicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.medicineDao;

/**
 * Servlet implementation class adm_MedicineFixServlet
 */
@WebServlet("/adm_MedicineFixServlet")
public class adm_MedicineFixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_MedicineFixServlet() {
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
		
		
		//获取药品信息
		String mid2 = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mprice2 = request.getParameter("mprice");
		String mnum2 = request.getParameter("mnum");
		String mdate = request.getParameter("mdate");
		
		int mid = Integer.parseInt(mid2);
		int mprice = Integer.parseInt(mprice2);
		int mnum = Integer.parseInt(mnum2);
		
		
		boolean a = medicineDao.chanage(mid,mname,mprice,mnum,mdate);
		
		if(a==true) {
			request.getSession().setAttribute("ch","修改成功");
			response.sendRedirect("/Hospital/adm_medicine.jsp");		
		}else {
			request.getSession().setAttribute("ch","修改失败");
			response.sendRedirect("/Hospital/adm_medicine.jsp");
		}
	}

}
