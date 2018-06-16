<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
   <link type="text/css" rel="stylesheet"  href="css/03.css">
   <title>用户登录</title>
  </head>
  
  <body>
  <div id="header">
  <h1 align="center" >图书管理系统</h1>
  </div>
	<div class="sideright">
   <form action="logincheck" method="post">
    
     <table border="0" >												
		<tr>
			<td id="t">用户名：*</td>
			<td><input type="text" name="userid" /></td>			
		</tr>
		<tr>
			<td id="t">密码：*</td>
			<td><input type="password" name="userpwd"/></td>			
		</tr>		
		<tr>
			<td colspan="3" align="center" height="40">
				  <input type="submit" value="登录" onclick="formcheck()">
				<input type="reset" value="取消"/>&nbsp;&nbsp;&nbsp;&nbsp;
	 没有账户？去<a href="form.html" >注册</a>
			</td>
		</tr>
	</table>
	 </form>
</div>
<div class="main">
	
<h2> 基于JSP+Servlet+JavaBean+JDBC+DAO的Web架构设计 </h2>
<p>包括3个实体类Book、User和Jbook对应数据库中的3张表</p>

</div>
<div class="main">
	
<h2>根据user表确定用户是否存在</h2>
</div>	
    
  </body>
</html>
