package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Book;
import beans.Jbook;
import dbc.JdbcUtil;
import javax.servlet.http.HttpServlet;
public class JbookDao {
	// 查询全部借书记录的方法queryAll()
		public List<Jbook> queryAll() throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Jbook> userList = new ArrayList<Jbook>();
			try {
				conn = JdbcUtil.getConnection2();
				String sql = "select * from jbook";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Jbook jbook =new Jbook();
					jbook.setId(rs.getInt(1));
					jbook.setBid(rs.getInt(2));
					jbook.setUname(rs.getString(3));
					
					userList.add(jbook);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return userList;
		}
		// 查询个人全部借书记录的方法query()
		
}
