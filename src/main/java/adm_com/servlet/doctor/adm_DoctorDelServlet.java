package adm_com.servlet.doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.DoctorDao;

/**
 * Servlet implementation class adm_DoctorDelServlet
 */
@WebServlet("/adm_DoctorDelServlet")
public class adm_DoctorDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DoctorDelServlet() {
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
		int did = Integer.parseInt(did2);

		boolean sta = DoctorDao.delete(did);
		if(sta==true){
			request.getSession().setAttribute("sta", "删除成功");
			response.sendRedirect("/Hospital/adm_doctor.jsp");
		}else {
			request.getSession().setAttribute("sta", "删除失败");
			response.sendRedirect("/Hospital/adm_doctor.jsp");
		}
	}

}
