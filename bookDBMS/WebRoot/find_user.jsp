<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="dao.UserDao"%>
<%@page import="beans.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'find_user.jsp' starting page</title>
    
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
			UserDao userdao = new UserDao();
			List<User> list = userdao.queryAll();
			Iterator<User> iter = list.iterator();
						//使用PreparedStudio对象实现数据库查询，其步骤如下：
						//（1）建立数据库的连接
						//（2）形成查询SQL语句
						//（3）利用数据库连接对象建立PreparedStatement对象
						//调用PreparedStatement的对象的executeQuery（）方法，并返回ResultSet对象
						//将光标移动到最后一行之后，然后通过list.size()方法知道有多少条数据，从而得到用户数据表中的记录数量
		
		%>你要查询的用户数据表中共有 <font size="5" color="red"><%=list.size()%></font>名用户
		<table border="2" bgcolor="ccceee" width="650">
			<tr bgcolor="CCCCCC" align="center">
				<td>记录条数</td>
				<td>用户名</td>								
			</tr>
			<%
				//将光标移动第一行之前，然后通过next()方法一行一行地遍历用户数据表中的记录
				while (iter.hasNext()) {
				User user = iter.next();
			%>
			<tr align="center">
				<td><%=row%></td>
				<td><%=user.getUsername()%></td>
				
			</tr>
			<%
				++row;
					}
			%>
		</table>
	</center>
  </body>
</html>
