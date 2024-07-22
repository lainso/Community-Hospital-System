package doc_com.servlet.doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.DoctorDao;
import doc_com.dao.LoginfoDao;

/**
 * Servlet implementation class doc_DoctorLogServlet
 */
@WebServlet("/doc_DoctorLogServlet")
public class doc_DoctorLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doc_DoctorLogServlet() {
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
		String dpass = request.getParameter("dpass");

		int did = Integer.parseInt(did2);

		boolean sta = DoctorDao.login(did, dpass);
		LoginfoDao.add(did);
		if(sta==true){
			response.sendRedirect("/Hospital/doctor_index.jsp");
		}else {
			request.getSession().setAttribute("sta2", "登录失败，请检查账号密码");
			response.sendRedirect("/Hospital/doctor_login.jsp");
		}
	}

}
