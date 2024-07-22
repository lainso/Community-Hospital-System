package adm_com.servlet.medicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.medicineDao;

/**
 * Servlet implementation class adm_MedicineDelServlet
 */
@WebServlet("/adm_MedicineDelServlet")
public class adm_MedicineDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_MedicineDelServlet() {
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
		String mid2 = request.getParameter("mid");
		
		int mid = Integer.parseInt(mid2);
		
		boolean ch = medicineDao.delete(mid);
		
		if(ch==true) {
			request.getSession().setAttribute("ch","信息删除成功");
			response.sendRedirect("/Hospital/adm_medicine.jsp");		
		}else {
			
			request.getSession().setAttribute("ch","信息删除失败,请重试");
			response.sendRedirect("/Hospital/adm_medicine.jsp");
		}
	}

}
