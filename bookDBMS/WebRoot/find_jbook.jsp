<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="beans.Jbook"%>
<%@page import="java.sql.*"%>
<%@page import="dbc.JdbcUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'find_jbook.jsp' starting page</title>
    
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
			String unm =(String) request.getSession().getAttribute("tp");
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
				conn = JdbcUtil.getConnection2();
				String sql = " select * from jbook where uname = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, unm);
				rs = ps.executeQuery();
				rs.last();
			//将光标移动到最后一行之后，然后通过getRow()方法获取当前行号，从而得到学生数据表中的记录数量
			session.setAttribute("num", rs.getRow());
		%>你共有 <font size="5" color="red"><%=rs.getRow()%></font>条借书记录
		 <table border="2" bgcolor="ccceee" width="650">
		 	<tr bgcolor="CCCCCC" align="center">
		 		<td>记录条数</td>
				<td>借书号</td>
				<td>图书id</td>
				<td>借书人</td>				
		 	</tr>
		 	<%
				//将光标移动第一行之前，然后通过next()方法一行一行地遍历学生数据表中的记录
				rs.beforeFirst();
				while (rs.next()) {
			%>
			<tr align="center">
				<td><%=rs.getRow()%></td>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getInt("bid")%></td>
				<td><%=rs.getString("uname")%></td>
			</tr>
			<%
				}
			%>
		</table>	
	</center>
	<%
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	%>
  </body>
</html>
