<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="total" class="pack.Jspex12form" />
    <jsp:setProperty property="*" name="total"/>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
처누의 과일집 가격 출력<br>
과일은 : <jsp:getProperty property="flot" name="total"/><br>
정가는 : <jsp:getProperty property="prc" name="total"/><br>
할인가 : <jsp:getProperty property="disc" name="total"/><br>
<%-- 정가 - 할인가 금액 --%>
<jsp:useBean id="avg" class="pack.Jspex12Logic"></jsp:useBean>
<jsp:setProperty property="total" name="avg" value="<%=total%>"/>
과읠의 구매가격은 : <jsp:getProperty property="result" name="avg"/>
</body>
</html>