<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
	<h2>EL 연산자와 내장객체</h2>
	--- 연산자 연습 ---
	<br> \${5 / 4 } ==> ${5 / 4 } <%-- ${5 div 4 } --%> = 나누기
	<br> \${5 / 0 } ==> ${5 / 0 } <%-- ${5 div 0 } --%> = 나누기
	<br> \${5 % 4 } ==> ${5 % 4 } ${5 mod 4 } = 나머지
	<br> \${5 > 4 } ==> ${5 > 4 } ${5 gt 4 } = 비교
	<br> \${5 <= 4 } ==> ${5 <= 4 } ${5 le 4 } = 비교
	<br> \${5 >= 4 and 3 < 2} ==> ${5 >= 4 and 3 < 2 } = or and 연산자
	<br> \${5 >= 4 or 3 < 2} ==> ${5 >= 4 or 3 < 2 } = or and 연산자
	<br> \${5 >= 4?10:5+20} ==> ${5 >= 4?10:5+20 } = 삼항연산자
	<br>
	<hr>

	<%
	request.setAttribute("aa", "air");
	request.setAttribute("bb", "burger");
	application.setAttribute("cc", "cat");
	%>
	
	<br>* 생존 범위 관련 내장객체 값 출력 *
	<br> JSP :
	<%=request.getAttribute("aa")%>
	==> EL : ${requestScope.aa }, ${aa }
	<br> JSP :
	<%=request.getAttribute("bb")%>
	==> EL : ${requestScope.bb }
	<br> JSP :
	<%=request.getAttribute("cc")%>
	==> EL : ${applicationScope.cc }
	<br>
	<br> JSP 의 header :
	<%=request.getHeader("host")%><br> El 로 header : ${header.host},
	${header["host"]}
	<br>
	<br>
	<hr>
	
	* Collection 객체 값 처리 *
	<br>
	
	<%
	ArrayList<String> list = new ArrayList<>();
	list.add("치즈 버거");
	list.add("치킨 버거");
	list.add("불고기 버거");
	request.setAttribute("foodlist", list);

	ArrayList<String> list2 = new ArrayList<>();
	list2 = (ArrayList) request.getAttribute("foodlist");
	out.println("JSP 로 출력 : " + list2.get(0));
	out.println("JSP 로 출력 : " + list2.get(1));
	%>
	
	<br> EL 로 출력 : ${foodlist[0]} , ${foodlist[1]} , ${foodlist[2]}
	<br>
	<hr>
	-- HTML 문서의 자료 받기 --
	<br>
	<a href="el_2.html">el_2 호출</a>
	<br> JSP로 이름 :
	<%
	String irum = request.getParameter("irum");
	if (irum != null) {
		out.print(irum);
	}
	%>
	<br>
	<%
	String[] sungs = request.getParameterValues("sung");
	if (sungs != null) {
		for (String s : sungs) {
			out.print(s + "");
		}
	}
	%>
	<br> EL 로 이름 : ${param.irum } , ${param["irum"]}
	<br> ${paramValues.sung[0]} , ${paramValues.sung["1"]}
	<br>
</body>
</html>