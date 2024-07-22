package adm_com.servlet.doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adm_com.dao.DoctorDao;

/**
 * Servlet implementation class adm_DoctorAddServlet
 */
@WebServlet("/adm_DoctorAddServlet")
public class adm_DoctorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DoctorAddServlet() {
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
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 从前端获取参数
		String did2 = request.getParameter("did");
		String dpass = request.getParameter("dpass");
		String dname = request.getParameter("dname");
		String dsex = request.getParameter("dsex");
		String droom = request.getParameter("droom");
		String dtel2 = request.getParameter("dtel");
		String djob2 = request.getParameter("djob");

		// 由于前端获取回来的都是字符串，我们需要跟dao层对接，就要将一些数据类型转化一些
		int did = Integer.parseInt(did2);
		Long dtel = Long.parseLong(dtel2);
		int djob = defineJob(djob2);

		// 调用dao层的医生添加方法，存到一个布尔值的状态里面
		boolean sta = DoctorDao.add(did, dpass, dname, dsex, droom, dtel, djob);
		if(sta==true){
			// 在浏览器的session（对话）中存放一个key为sta，value为注册成功的对象中，给前端用
			request.getSession().setAttribute("sta", "添加成功");
			// 重定向一下页面，帮助前端更新数据
			response.sendRedirect("/Hospital/adm_index.jsp");
		}else {
			// 失败了也给一个session对象
			request.getSession().setAttribute("sta", "添加失败");
			// 重定向
			response.sendRedirect("/Hospital/adm_index.jsp");
		}
	}

}
