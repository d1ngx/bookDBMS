package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Book;
import dbc.JdbcUtil;
public class BookDao {
	// 向数据库中添加图书记录的方法add()
	public Book add(Book book) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "insert into book values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setString(5, book.getNote());
			ps.setInt(6, book.getNum());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return book;
		
	}

	//修改数据库图书记录的方法update()
	public void update(Book book) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "update book set name=?,author=?,price=?,note=?,num=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setFloat(3, book.getPrice());
			ps.setString(4, book.getNote());
			ps.setInt(5, book.getNum());
			ps.setInt(6, book.getId());
			ps.executeUpdate();
			
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		
	}

	// 删除数据库图书记录的方法delete()
	public void delete(int Id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "delete from book where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据id查询图书的方法findUserById
	public Book findBookById(int Id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "select * from book where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setNote(rs.getString(5));
				book.setNum(rs.getInt(6));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return book;
	}

	// 查询全部图书的方法queryAll()
	public List<Book> queryAll() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> userList = new ArrayList<Book>();
		try {
			conn = JdbcUtil.getConnection2();
			String sql = "select * from book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book =new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setNote(rs.getString(5));
				book.setNum(rs.getInt(6));
				userList.add(book);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return userList;
	}
}
