<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel='stylesheet' type='text/css' href='css/css.css'>
<%
// insert 후 목록보기로 이동
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="formBean" class="pack.SangpumFormBean" />
<jsp:setProperty property="*" name="formBean"/>
<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling" />

<% 
boolean b = dbConnPooling.insertData(formBean);

if(b)
	response.sendRedirect("jspex17dbcp.jsp");	// 추가 성공 후 상품 보기
else
	response.sendRedirect("jspex17fail.html");	// 추가 성공 후 상품 보기
%>