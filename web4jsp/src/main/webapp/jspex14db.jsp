<%@page import="pack.JikwonDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="db" class="pack.JikDbConn" />
<jsp:setProperty name="db" property="bname" param="name" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
<table class="wide-table" border="1">
<tr><td colspan="4"> 부서명 :<%=db.getBname() %></td></tr>
<tr><th>사번</th><th>직원명</th><th>직급</th><th>성별</th></tr>
<% ArrayList<JikwonDto> list = db.getDataAll();
for(JikwonDto s:list){ %>
<tr>
	<td><%=s.getNo()%></td>
	<td><%=s.getName()%></td>
	<td><%=s.getJik() %></td>
	<td><%=s.getGen() %></td>
</tr>
<%}%>
<tr>
<td colspan="4">인원 수 :<%=list.size() %></td>
</tr>
<% db.getJikPay(); %>
<tr><td colspan="2">최고 연봉: <%= db.getMaxPay() %></td>
<td colspan="2">최저 연봉: <%= db.getMinPay() %></td></tr>
</table>
</body>
</html>