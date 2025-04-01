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

// 비밀번호가 없거나 일치하지 않으면 리디렉션
if(pwd == null || !pwd.equals("kor")){
    response.sendRedirect("js39jquerycheck.html");
    return;  // 리디렉션 후 코드 실행을 막기 위해 return 추가
}

String id = request.getParameter("userid");
String age = request.getParameter("age");

// 입력 값 검증
if(id == null || age == null) {
    out.println("입력 값이 누락되었습니다.");
} else {
    out.println(id + "님의 나이는 " + age);
}
%>
</body>
</html>
