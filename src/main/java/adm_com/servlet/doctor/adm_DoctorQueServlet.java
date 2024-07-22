package adm_com.servlet.doctor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.DoctorDao;
import adm_com.model.Doctor;

/**
 * Servlet implementation class adm_DoctorQueServlet
 */
@WebServlet("/adm_DoctorQueServlet")
public class adm_DoctorQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DoctorQueServlet() {
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

		String did2 = request.getParameter("did");
		
		ArrayList<Doctor> a;
		if(did2.equals("")) {
			a = DoctorDao.getList();
			request.getSession().setAttribute("sta", "查询成功");
		}else{
			int did = Integer.parseInt(did2);
			a = DoctorDao.getList(did);
			request.getSession().setAttribute("sta", "查询失败");
		}
		request.getSession().setAttribute("doctorlist",a);
		response.sendRedirect("/Hospital/adm_doctor.jsp");
	}

}
