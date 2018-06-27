package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Book;
import beans.User;
import dbc.JdbcUtil;

public class UserDao {
	// 添加用户的方法save()
	public User save(User usr) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into User values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usr.getUsername());
			ps.setInt(2, usr.getUserpwd());			
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return usr;		
	}
	// 删除数据库用户记录的方法delete()	
	public void delete(String username) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from user where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}
	// 查找用户是否存在的方法findUser
	public boolean findUser(String username) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {				
				result = true;
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}	
		return result;
	}
	// 检查用户名密码是否一致
	public boolean checkUser(String userId,int userPwd) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		boolean result = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String uname = rs.getString("uname");
				int upassword = rs.getInt("upassword");
				if(userId.equals(uname)&&userPwd==upassword){
					result = true;
				}
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return result;
	}

	// 查询全部用户的方法queryAll()
	public List<User> queryAll() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setUsername(rs.getString(1));
				
				userList.add(user);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return userList;
	}
}
