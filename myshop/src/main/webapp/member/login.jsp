<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String id = (String) session.getAttribute("idKey");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
<style>
/* 카드 스타일 */
.login-card {
  width: 350px;
  margin: 100px auto;
  padding: 30px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-radius: 15px;
  background-color: #fff;
  font-family: sans-serif;
}

.login-card h2 {
  text-align: center;
  margin-bottom: 20px;
}

.login-card input[type="text"] {
  width: 100%;
  padding: 10px;
  margin-top: 8px;
  margin-bottom: 16px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.login-card input[type="button"] {
  width: 48%;
  padding: 10px;
  margin-top: 10px;
  border: none;
  border-radius: 8px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
  font-weight: bold;
}

.login-card input[type="button"]:last-child {
  background-color: #2196F3;
}

.login-card input[type="button"]:hover {
  opacity: 0.9;
}
</style>

<script type="text/javascript">
window.onload = () => {
	document.querySelector("#btnLogin").addEventListener("click", funcLogin);
	document.querySelector("#btnNewMember").addEventListener("click", funcNewMember);
}
</script>
</head>
<body>

<%
if (id != null) { // 로그인 한 경우
%>
	<div class="login-card">
		<h2><%=id %>님 환영합니다 🎉</h2>
		<p>이제부터 우리가 준비한 쇼핑몰 기능을 사용할 수 있어요.</p>
		<a href="logout.jsp" style="display:inline-block; margin-top:20px; text-align:center; color:#2196F3;">로그아웃</a>
	</div>
<%
} else { // 로그인 안 한 경우
%>
	<div class="login-card">
		<h2>로그인</h2>
		<form name="loginForm">
			<label>아이디</label>
			<input type="text" name="id" placeholder="아이디를 입력하세요">

			<label>비밀번호</label>
			<input type="text" name="passwd" placeholder="비밀번호를 입력하세요">

			<div style="display: flex; justify-content: space-between;">
				<input type="button" value="로 그 인" id="btnLogin">
				<input type="button" value="회원가입" id="btnNewMember">
			</div>
		</form>
	</div>
<%
}
%>

</body>
</html>
