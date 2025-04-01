<%@page import="pack.GuestbookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String code = request.getParameter("code");
    %>
    
    <jsp:useBean id="dbConnPooling" class="pack.DbConnPooling" />
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
<%
GuestbookDto dto = dbConnPooling.updateDataRead(code);
if(dto == null){
%>
	<script type="text/javascript">
		alert("다시 한번 확인해주세요");
		location.href = "jspex17dbcp.jsp";
	</script>
	<% 
	return;
}
%>
* 방명록 수정 *<br>
<form action="jspex17upok.jsp" method="post">
코드 : <%= dto.getWriter() %>
<input type="hidden" name="code" value="<%= dto.getCode()%>"><br>
작성자 : <input type="text" name="writer" value="<%= dto.getWriter()%>"><br>
제목 : <input type="text" name="title" value="<%= dto.getTitle()%>"><br>
내용 : <input type="text" name="contents" value="<%= dto.getContents()%>"><br>
<input type="submit" value="방문록 수정">
<input type="button" value="수정 취소" onclick="javascript:location.href='jspex17dbcp.jsp'">

</form>
</body>
</html>