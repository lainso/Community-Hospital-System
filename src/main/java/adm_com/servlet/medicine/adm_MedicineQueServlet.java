package adm_com.servlet.medicine;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.medicineDao;
import adm_com.model.Medicine;

/**
 * Servlet implementation class adm_MedicineQueServlet
 */
@WebServlet("/adm_MedicineQueServlet")
public class adm_MedicineQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_MedicineQueServlet() {
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
		
		
		//获取查询信息
		String mid = request.getParameter("mid");
		
		
		ArrayList<Medicine> a;
		
		if(mid.equals("")) {
			a = medicineDao.get_List();
			request.getSession().setAttribute("ch","信息查询成功");
		}else {
			a = medicineDao.get_List(mid);
			request.getSession().setAttribute("ch","信息查询成功");
		}		
		
		request.getSession().setAttribute("usermessage", a);
			
		response.sendRedirect("/Hospital/adm_medicine.jsp");	
	}
	

}
