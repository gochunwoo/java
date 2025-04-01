<%@page import="pack.member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="memberManager" class="pack.member.MemberManager"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자--회원관리</title>
<link href="../css/style.css?v=1.0" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h2>* 관리자 전체회원 관리 *</h2>
<%@include file="admin_top.jsp" %>

<table>
	<tr>
		<th>아이디</th><th>고객명</th><th>이메일</th><th>전화</th><th>수정</th>
	</tr>
	<%
	// 전체 회원정보를 리스트로 가져오기
	ArrayList<MemberDto> list = memberManager.getMemberAll();
	
	for(MemberDto m : list){ // 리스트가 비어 있지 않으면 반복해서 출력
	%>
	<tr>
		<td><%= m.getId() %></td>
		<td><%= m.getName() %></td>
		<td><%= m.getEmail() %></td>
		<td><%= m.getPhone() %></td>
		<td>
		<a href="javascript:memberUpdate('<%= m.getId() %>')">수정하기</a></td>
		
	</tr>
	<% 	
	}
	%>
</table>
<%@include file="admin_bottom.jsp" %>
<%-- 회원의 정보를 수정 --%>
<form action="memberupdate_admin.jsp" name="updateFrm" method="post">
<input type="hidden" name="id">

</form>
</body>
</html>