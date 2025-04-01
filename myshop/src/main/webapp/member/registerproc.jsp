<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");%>
    
    <jsp:useBean id="mbean" class="pack.member.MemberBean" />
    <jsp:setProperty property="*" name="mbean"/>
    <jsp:useBean id="memberManager" class="pack.member.MemberManager" />
    <%
    boolean b = memberManager.memberInsert(mbean);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
if(b){
	%>
	<b>회원가입을 축하합니다</b><br><br>
	<a href="login.jsp">회원 로그인</a><br>
	<% 
}else{
	%>
	<b>회원가입 실패입니다.</b><br><br>
	<a href="register.jsp">회원 로그인</a><br>	
	<% 
}
%>
</body>
</html>