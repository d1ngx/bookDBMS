package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;



import dao.BookDao;

public class BookInsert extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author= req.getParameter("author");
		Float price = Float.parseFloat(req.getParameter("price"));
		String note= req.getParameter("note");
		int num = Integer.parseInt(req.getParameter("num"));
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		book.setNote(note);
		book.setNum(num);
		BookDao bookdao = new BookDao();
		try {
			if(bookdao.add(book) != null){
				req.getRequestDispatcher("successDB.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("errorDB.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
