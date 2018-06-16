<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <base href="<%=basePath%>">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>My JSP 'index_user_left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/bgleft.css">
	

  </head>
  
  <body>
    <br><br><br><br><br><br>

 <p><a href="find_book.jsp"target="right" class="btn btn-primary btn-lg">全部图书 <span class="glyphicon glyphicon-asterisk"></span></a></p>
 <p><a href="Jbook_tijiao.jsp"target="right" class="btn btn-primary btn-lg">借阅图书 <span class="glyphicon glyphicon-asterisk"></span></a></p>
 <p><a href="find_jbook.jsp"target="right" class="btn btn-primary btn-lg">已借图书 <span class="glyphicon glyphicon-asterisk"></span></a></p>
 <p><a href="h_book_tijiao.jsp"target="right" class="btn btn-primary btn-lg">归还图书 <span class="glyphicon glyphicon-asterisk"></span></a></p>
 
  </body>
</html>
