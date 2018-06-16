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
    
    <title>My JSP 'find_book.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	

  </head>
  
  <body>
  	<center>
  		<%! int row; %>
		<%	
			request.setCharacterEncoding("UTF-8");
			row = 1;
			BookDao bookdao = new BookDao();
			List<Book> list = bookdao.queryAll();
			Iterator<Book> iter = list.iterator();
						//使用PreparedStudio对象实现数据库查询，其步骤如下：
						//（1）建立数据库的连接
						//（2）形成查询SQL语句
						//（3）利用数据库连接对象建立PreparedStatement对象
						//调用PreparedStatement的对象的executeQuery（）方法，并返回ResultSet对象
						//将光标移动到最后一行之后，然后通过list.size()方法获取当前数据总条数，从而得到图书数据表中的记录数量
		
		%>你要查询的图书数据表中共有 <font size="5" color="red"><%=list.size()%></font>种书
		<table border="2" bgcolor="ccceee" width="650">
			<tr bgcolor="CCCCCC" align="center">
				<td>记录条数</td>
				<td>图书号</td>
				<td>图书名</td>
				<td>作者</td>
				<td>价格</td>
				<td>出版社</td>
				<td>数量</td>
			</tr>
			<%
				//将光标移动第一行之前，然后通过next()方法一行一行地遍历图书表中的记录
				while (iter.hasNext()) {
				Book book = iter.next();
			%>
			<tr align="center">
				<td><%=row%></td>
				<td><%=book.getId()%></td>
				<td><%=book.getName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getNote()%></td>
				<td><%=book.getNum()%></td>
			</tr>
			
			<%
				++row;
					}
			%>
		</table>
	</center>
  </body>
</html>
