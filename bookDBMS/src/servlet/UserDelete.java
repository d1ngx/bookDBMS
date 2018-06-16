package servlet;
import dao.UserDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import beans.Book;

public class UserDelete extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String uname = req.getParameter("uname");
		
		UserDao userdao = new UserDao();
		try {
				userdao.delete(uname);
				req.getRequestDispatcher("successDB.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("errorDB.jsp").forward(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
