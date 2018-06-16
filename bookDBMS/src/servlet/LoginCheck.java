package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dbc.JdbcUtil;

public class LoginCheck extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(); 
		// PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String  userp = request.getParameter("userpwd");
		try{
			int userpwd = Integer.parseInt(userp);
			int upwd = 123456;
			UserDao userdao = new UserDao();
			if("".equals(userid)||"".equals(userp))
			{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			else{
			 try {
				 	if("admin".equals(userid)&&userpwd==upwd){
				 		request.getRequestDispatcher("admin.jsp").forward(request, response);
				 	}
				 	else if(userdao.checkUser(userid,userpwd) != false){
				 		session.setAttribute("tp", userid);
				 		request.getRequestDispatcher("User.jsp").forward(request, response);
					} 
				 	else  {
				 		request.getRequestDispatcher("error.jsp").forward(request, response);
							 
						  }
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			}catch(NumberFormatException ex){ // handle your exception
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		
		
}		
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here		
	}

}
