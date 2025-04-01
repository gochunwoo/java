<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 세션 읽기
if (session.getAttribute("userid") != null) { // 사용자가 로그인 하고 이파일을 호출한 경우
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
	<h2>🥳🥳축하합니다. 로그인(Authorization,인가)에 성공했습니다.🥳🥳</h2>
	<pre>
준비된 
쇼핑, 
게시판, 
회의참여 등의 작업을 할 수 있어요
</pre>
	<a href="jspex8logout.jsp">로그아웃</a>
</body>
</html>

<%
} else {
// 사용자가 로그인 하지 않고 이파일을 호출한 경우
response.sendRedirect("jspex8login.html");
}
%>