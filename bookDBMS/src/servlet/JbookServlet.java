package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Jbook;
import dao.JbookDao;
import dbc.JdbcUtil;

public class JbookServlet extends HttpServlet {

	
		public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
			req.setCharacterEncoding("utf-8");
			HttpSession session=req.getSession(); 
			//Jbook jbook = new Jbook();
			//jbook.setId(Integer.parseInt(id));
			Connection conn = null;
			PreparedStatement ps = null;
			
			int id = Integer.parseInt(req.getParameter("id"));
			String uname =(String) req.getSession().getAttribute("tp");
			//int n = 1;
			
			//String num="1";
			//String num =(String) req.getSession().getAttribute("num");
			//int nm = Integer.parseInt(num);
			//try{	
			//session.setAttribute("num", ++n);
			int n2 = (Integer)session.getAttribute("num");	
			if(n2>3){req.getRequestDispatcher("warning.jsp").forward(req, resp);}
			else try {
				conn = JdbcUtil.getConnection2();
				String sql = "update book set num = (num -1) where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
				String sql2 = " insert into jbook(bid,uname) values(?,?)";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, id);
				ps.setString(2, uname);
				ps.executeUpdate();
				//++n;
				
				//session.setAttribute(num, ++n);
				req.getRequestDispatcher("successDB.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.getRequestDispatcher("errorDB.jsp").forward(req, resp);
			}finally {
				JdbcUtil.free(null, ps, conn);
				}				
			}//catch(NumberFormatException ex){ // handle your exception
				//req.getRequestDispatcher("error.jsp").forward(req, resp);
			//}
			
			
		//}
		
		public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
			this.doGet(req, resp);
		}

}
