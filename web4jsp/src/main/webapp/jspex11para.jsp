<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
// String name = request.getParameter("name");	// 지금까지는 이렇게 함 이제 빈즈를 사용해본다
%>
<%-- 
낱개로 받는다면 이렇게
<jsp:useBean id="formBean" class="pack.Jspex11FormBean" />
<jsp:setProperty property="name" name="forBean"/>
--%>
<%-- property="*" 자동으로 모든값이 setter 를 통해저장됨 --%>
<jsp:useBean id="formBean" class="pack.Jspex11FormBean"></jsp:useBean>
<jsp:setProperty property="*" name="formBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
폼빈의 저장된 자료 출력 <br>
이름은 <jsp:getProperty property="name" name="formBean"/><br>
국어는 <jsp:getProperty property="kor" name="formBean"/><br>
영어는 <jsp:getProperty property="eng" name="formBean"/><br>
<%-- 게산을 위한 클래스를 Beans 사용 --%>
<jsp:useBean id="logic" class="pack.Jspex11Logic" />
<jsp:setProperty property="formBean" name="logic" value="<%=formBean%>"/>
총점은 : <jsp:getProperty property="tot" name="logic"/><br>
평균은 : <jsp:getProperty property="avg" name="logic"/>
</body>
</html>