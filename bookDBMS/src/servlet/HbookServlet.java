package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Jbook;
import dbc.JdbcUtil;

public class HbookServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		//Jbook jbook = new Jbook();
		//jbook.setId(Integer.parseInt(id));
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		//Jbook jbook = null;
		
		//String uname =(String) req.getSession().getAttribute("tp");
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "update book set num = (num +1) where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			String sql1 = " delete from jbook where bid = ?";
			ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, id);			
			ps1.executeUpdate();
			req.getRequestDispatcher("successDB.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("errorDB.jsp").forward(req, resp);
		}finally {
			JdbcUtil.free(null, ps, conn);
		}	
		
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
