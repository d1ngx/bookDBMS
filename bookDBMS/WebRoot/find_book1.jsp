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
    
    <title>由提交页面获取查询条件并实现查询的页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">

  </head>
  
  <body>
    <center>
		<%
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			
			BookDao bookdao = new BookDao();
			
			Book book=bookdao.findBookById(id);
			if (book != null){
		%>查询结果为：
		 <table border="2" bgcolor="ccceee" width="650">
		 	<tr bgcolor="CCCCCC" align="center">
		 		
				<td>图书号</td>
				<td>图书名</td>
				<td>作者</td>
				<td>价格</td>
				<td>出版社</td>
				<td>数量</td>
		 	</tr>
			<tr align="center">
				<td><%=book.getId()%></td>
				<td><%=book.getName()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getNote()%></td>
				<td><%=book.getNum()%></td>
			</tr>
		</table>
		<%
		} else {
	%>
	没有找到合适条件的记录！！<%
		
		}
	%>
	</center>
  </body>
</html>
