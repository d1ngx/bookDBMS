<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改记录的条件提交页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
   	请选择修改记录所满足的条件<hr width="100%" size="3">
			<form action="update_book_edit.jsp" method="post">
				图书id：<input type="text" name="id"><br><br>
				
				<button type="submit" class = "btn btn-success btn-sm">提交</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class = "btn btn-success btn-sm">取消</button>
			</form>
  </body>
</html>
