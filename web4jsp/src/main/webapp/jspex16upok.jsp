<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
<link rel='stylesheet' type='text/css' href='css/css.css'>
<jsp:useBean id="formBean" class="pack.SangpumFormBean" />
<jsp:setProperty property="*" name="formBean"/>
<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling" />

<%
// boolean b = dbConnPooling.updateData(formBean);

if(dbConnPooling.updateData(formBean))
	response.sendRedirect("jspex16dbcp.jsp");	// 수정후 원래화면
else
	response.sendRedirect("jspex16fail.html");	// 수정 실패시 이동 페이지
%>