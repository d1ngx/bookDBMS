<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询条件提交页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
    请输入要查询图书的id:<br><hr width="100%" size="3">
		<form action="find_book1.jsp" method="post">
			id：&nbsp;<input type="text" name="id"><br> <br>
			<button type="submit" class = "btn btn-success btn-sm">提交</button>
		</form>
  </body>
</html>
