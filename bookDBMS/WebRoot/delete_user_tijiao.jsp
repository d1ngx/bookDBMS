<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除用户提交页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
    请选择删除记录条件:<br><hr width="100%" size="3">
	<form action="userdelete" method="post">
	请输入用户名:<input type="text" name="uname" > <br><br>
		<button type="submit" class = "btn btn-success btn-sm">提交</button> &nbsp;&nbsp;&nbsp;&nbsp; 
		<button type="reset" class = "btn btn-success btn-sm">取消</button>
	</form>
  </body>
</html>
