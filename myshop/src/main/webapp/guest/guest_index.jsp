<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css?v=1.0" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>

<div class="container">
  <h1>쇼핑몰</h1>
  

  <%@include file="guest_top.jsp"%>

  <% 
    if(memid != null){
  %>	
    <div style="
    width: 600px;
    height: 600px;
    background-image: url('../images/shopmain.gif');
    background-size: cover;
    background-position: center;
    border-radius: 50px;
    margin-top: 50px;">
    <p><%=memid %>님! 방문을 환영합니다.</p>
</div>

  <%} else { %>
    <div class="notice" style="
    width: 600px;
    height: 600px;
    background-image: url('../images/main.gif');
    background-size: cover;
    background-position: center;
    border-radius: 50px;
    margin-top: 50px;">
      <p>고객님 어서오세요.</p>
      <p>로그인 후 이동바랍니다.</p>
      
    </div>
  <% } %>

  <%@include file="guest_bottom.jsp"%>
</div>

</body>
</html>
