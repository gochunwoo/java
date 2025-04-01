<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/css.css">
</head>
<body>
<%
session.removeAttribute("adminOk");	// 세션 삭제 로그 아웃
%>
<br><br>
 <a href="javascript:window.close()">창 닫 기</a> 
</body>
</html>