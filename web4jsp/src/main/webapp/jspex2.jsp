<%-- page 지시어 : 현재 문서의 속성이나 정보 등을 선언 또는 지시하는 역할 --%>
<%@page import="java.time.ZoneId"%>
<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.time.LocalDate"
import="java.sql.Connection, java.sql.ResultSet"
session="true"
buffer="8kb"
autoFlush="true"
isThreadSafe="true"
info="jsp 문서정보 기록"
errorPage="jspex2err.jsp"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
<h2>Page 지시어</h2>
현재 날짜 출력 : 
<%
LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
out.println(now.getYear() + "년 " + now.getMonthValue() + "월 ");
%>
<%= now.getDayOfMonth() + "일" %>
<hr>
<%= 10 / 2 %>  <%-- 문법 에러, 런타임에러(처음부터 0으로 나눈 경우) 등은 개발자가 수정한다. --%>
			   <%--정상적으로 작동하던 페이지가 에러를 만난 경우는 별도의 화면을 제공해 주는 것이 효과적 --%>
</body>
</html>