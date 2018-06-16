<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书的提交页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bg.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
    <form action="bookinsert" method="post">
			请输入要添加图书的信息:<br><hr width="100%" size="3">
			<table border="0" width="330" height="252" style="font-family:'Microsoft YaHei';">
			<tr><td>id:</td><td><input type="text" name="id"></td></tr>
			<tr><td>书名:</td><td><input type="text" name="name"></td></tr>
			<tr><td>作者:</td><td><input	type="text" name="author"></td></tr>
			<tr><td>价格:</td><td><input type="text" name="price"></td></tr>
			<tr><td>出版社:</td><td><input	type="text" name="note"></td></tr>
			<tr><td>数量:</td><td><input	 type="text" name="num"></td></tr>
			<tr align="center" >
				<td colspan="3" >
					<button type="submit" class = "btn btn-success btn-sm">提交</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset" class = "btn btn-success btn-sm">取消</button>
				</td>
			</tr>
			</table>
		</form>
  </body>
</html>
