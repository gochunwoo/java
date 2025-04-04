<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String pwd = request.getParameter("pwd1");
if(!pwd.equals("kor")){
	response.sendRedirect("js39jquerycheck.html");
}

String id = request.getParameter("userid");
String age = request.getParameter("age");

out.println(id + "님의  나이는 " + age);
%>
</body>
</html>