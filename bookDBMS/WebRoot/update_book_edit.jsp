<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="dao.BookDao"%>
<%@page import="beans.Book"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改编辑页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
   <%						
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			//session.setAttribute("temp", id);
			BookDao bookdao = new BookDao();
			
			Book book=bookdao.findBookById(id);
			//int num = book.getNum();
			//session.setAttribute("temp2", num);
			if (book != null) {
			//int id2 = book.getId();
			//String name = book.getName();
			//String author = book.getAuthor();
			//float price = book.getPrice();
			//String note = book.getNote();	
																														
	%>
	<form action="bookupdate" method="post">
		<table border="0" width="238" height="252">
			<tr>
				<td>图书编号:</td>
				<td><input name="id" value=<%=book.getId()%>></td>
			</tr>
			<tr>
				<td>书名:</td>
				<td><input name="name" value=<%=book.getName()%>></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input name="author" value=<%=book.getAuthor()%>></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input name="price" value=<%=book.getPrice()%>></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input name="note" value=<%=book.getNote()%>></td>
			</tr>
			<tr>
				<td>数量:</td>
				<td><input name="num" value=<%=book.getNum()%>></td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<button type="submit" class = "btn btn-success btn-xs">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset" class = "btn btn-success btn-xs">取消</button>
				</td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	没有找到合适条件的记录！！<%
		
		}
	%>
  </body>
</html>
