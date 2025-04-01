<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");

if(!id.equalsIgnoreCase("aa")){
	response.sendRedirect("jspex7main.html");
}

// request.setAttribute("mykey", id); // 현재 jsp에서만 유효한 객체. 다른 jsp에서 사용할려면 전송필요
session.setAttribute("mykey", id);	// 내장 객체	-- 로그인한 사용자에 한해 모든 jsp 에서 사용가능
session.setMaxInactiveInterval(10); // 기본값은 30분

// application.setAttribute("mykey", id);	// 로그인 과 상관없이 모든 사용자에게 public
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
<h2>* 세션 연습 *</h2>
좋아하는 영화는 머야?

<form action="jspex7show.jsp">
<input type="radio" name="movie" value="미키17" checked="checked">미키17&nbsp;&nbsp;&nbsp;
<input type="radio" name="movie" value="백설공주">백설공주&nbsp;&nbsp;&nbsp;
<input type="radio" name="movie" value="콘틀라베">콘틀라베
<br><br>
<input type="submit" value="결과보기">
</form>
</body>
</html>