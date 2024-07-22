package adm_com.servlet.doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.DoctorDao;

/**
 * Servlet implementation class adm_DoctorFixServlet
 */
@WebServlet("/adm_DoctorFixServlet")
public class adm_DoctorFixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DoctorFixServlet() {
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
	
	public int defineJob(String djob){
		if(djob.equals("管理员")) {
			return 0;
		}else if(djob.equals("医生")){
			return 1;
		}else if(djob.equals("护士")){
			return 2;
		}else {
			return -1;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String did2 = request.getParameter("did");
		String dpass = request.getParameter("dpass");
		String dname = request.getParameter("dname");
		String dsex = request.getParameter("dsex");
		String droom = request.getParameter("droom");
		String dtel2 = request.getParameter("dtel");
		String djob2 = request.getParameter("djob");

		int did = Integer.parseInt(did2);
		Long dtel = Long.parseLong(dtel2);
		int djob = defineJob(djob2);

		boolean sta = DoctorDao.fix(dpass, dname, dsex, droom, dtel, djob, did);
		if(sta==true){
			request.getSession().setAttribute("sta", "修改成功");
			response.sendRedirect("/Hospital/adm_doctor.jsp");
		}else {
			request.getSession().setAttribute("sta", "修改失败");
			response.sendRedirect("/Hospital/adm_doctor.jsp");
		}
	}

}
