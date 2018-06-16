<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> <title>图书信息管理系统</title> </head>
  <frameset rows="80,*">
  <frame src="index_book_title.jsp" scrolling="no">
  <frameset cols="140,*">
   <frame src="index_book_left.jsp" scrolling="no">
    <frame src="index_book_right.jsp" name="right" scrolling="auto">
   </frameset>
  </frameset>
</html>
