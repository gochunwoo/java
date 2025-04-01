<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel='stylesheet' type='text/css' href='css/css.css'>
    
    
    
    
<%
String code = request.getParameter("code");

%>

<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling"></jsp:useBean>

<%
if(dbConnPooling.deleteData(code))
	response.sendRedirect("jspex17dbcp.jsp");	
else
	response.sendRedirect("jspex17fail.html");	
%>