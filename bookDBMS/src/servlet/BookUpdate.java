package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;




import dao.BookDao;


public class BookUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		String note = request.getParameter("note");
		int num = Integer.parseInt(request.getParameter("num"));
		//Integer temp = (Integer) request.getSession().getAttribute("temp");
		//Integer temp2 = (Integer) request.getSession().getAttribute("temp2");
		
		Book book = new Book();
		book.setId(id);
	
		book.setName(name); 
		book.setAuthor(author);
		book.setPrice(price); 
		book.setNote(note);
		book.setNum(num);
		BookDao bookdao = new BookDao();
		try {
			bookdao.update(book);
			request.getRequestDispatcher("successDB.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("errorDB.jsp").forward(request, response);
		};
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
