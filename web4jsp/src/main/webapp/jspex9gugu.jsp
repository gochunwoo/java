<%@page import="pack.Jspex9Gugu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
<b>* 현재 내 능력으로 할 수 있는 방법 *</b>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println("<br>" + dan + "단 출력<br>");

//Jspex9Gugu gugu = new Jspex9Gugu();	// 클래스의 포함관계
Jspex9Gugu gugu = Jspex9Gugu.getInstance();	// 클래스의 포함관계: 싱글톤 패턴

int result[] = gugu.computeGugu(dan);
for(int a = 0; a < result.length; a++){
out.println(dan + " X " + (a + 1) + " = " + result[a] + "&nbsp;&nbsp;");
}
%>
<hr>
<b>* beans 사용 *</b>
<br>
<!-- 1) useBean: JSP에서 Bean(자바 객체)을 꺼내 쓰겠다는 선언 

    - id="exBean" : JSP에서 쓰이는 Bean의 이름(별명)
    - class="pack.Jspex9Gugu" : 자바 클래스의 패키지와 이름
    - scope="request" : request 범위 동안 이 Bean이 살아 있음
-->
<jsp:useBean id="gugu2" class="pack.Jspex9Gugu"></jsp:useBean>
<%
int result2[] = gugu2.computeGugu(dan);
for(int a = 0; a < result2.length; a++){
out.println(dan + " X " + (a + 1) + " = " + result2[a] + "&nbsp;&nbsp;");
}
%>

</body>
</html>