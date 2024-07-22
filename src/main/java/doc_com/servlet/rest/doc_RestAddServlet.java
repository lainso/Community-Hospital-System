package doc_com.servlet.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doc_com.dao.restDao;

/**
 * Servlet implementation class doc_RestAddServlet
 */
@WebServlet("/doc_RestAddServlet")
public class doc_RestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doc_RestAddServlet() {
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
		String rid2 = request.getParameter("rid");
		String rreason = request.getParameter("rreason");
		String rstart = request.getParameter("rstart");
		String rend = request.getParameter("rend");
		String rcondition2 = request.getParameter("rcondition");
		
		boolean a=false;
		
		if(rid2.equals("")||rreason.equals("")||rstart.equals("")||rend.equals("")||rcondition2.equals("")) {
			request.getSession().setAttribute("ch","添加失败，，请检查表单是否填写完整");
		}else {
			int rid = Integer.parseInt(rid2);
		int rcondition = Integer.parseInt(rcondition2);
		a = restDao.add(rid,rreason,rstart,rend,rcondition);
		}
			
		
		//a==true表明注册成功
		//a==false表明注册失败
		
		if(a==true) {
			request.getSession().setAttribute("ch","添加成功");
				
		}else {
			request.getSession().setAttribute("ch","添加失败");
		}
		response.sendRedirect("/Hospital/doctor_rest.jsp");
	}

}
