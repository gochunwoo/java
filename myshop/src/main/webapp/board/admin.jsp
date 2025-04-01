<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<script type="text/javascript">
	function check(){
		if(frm.id.value === "" || frm.pwd.value === ""){
			alert("자료를 입력하세요");
		}
		frm.submit();
	}
	
</script>
</head>
<body>
	<form action="adminlogin.jsp" name="frm" method="post">
		<table>
			<tr>
				<td>
					<%
					String sessionValue = (String) session.getAttribute("adminOk");
					if (sessionValue != null) {
					%> 로그인 중입니다.<br>
				<br> <a href="adminlogout.jsp">
   						<button type="button">로그아웃</button></a>
						<button type="button" onclick="window.close()">창 닫 기</button>

					 <%
 				} else {
 					 %>
					<table>
						<tr>
							<td>아 이 디 : <input type="text" name="id"></td>
						</tr>
						<tr>
							<td>비 밀 번 호 : <input type="text" name="pwd"></td>
						</tr>
						<tr>
							<td>
						<a href="#" onclick="check()">로 그 인</a> 
						<a href="javascript:window.close()">창 닫 기</a>
							</td>
						</tr>
					</table> 
					<%
 					}
 					%>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>