<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="boardManager" class="pack.board.BoardManager" />
<jsp:useBean id="dto" class="pack.board.BoardDto" />

<%
String num = request.getParameter("num");
String bpage = request.getParameter("page");
dto = boardManager.getData(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<script type="text/javascript">
function check(){
	   if(frm.pass.value === ""){
	      frm.pass.focus();
	      alert("비밀번호를 입력하셈");
	      return;
	   }
	   
	   if(confirm("정말 수정할까요?")){
	      frm.submit();
	   }
	}
	
</script>
</head>
<body>
	<h2>* 글 수정 *</h2>
	<form action="editsave.jsp" name="frm" method="post">
	<input type="hidden" name="num" value="<%= num%>">
		<input type="hidden" name="poge" value="<%= bpage%>">
		<table border="1">
			<tr>
				<td>이 름</td>
				<td><input type="text" name="name" style="width: 98%"
					value="<%=dto.getName()%>"></td>
			</tr>
			<tr>
				<td>비 밀 번 호</td>
				<td><input type="password" name="pass" style="width: 98%">
				</td>
			</tr>
			<tr>
				<td>이 메 일</td>
				<td><input type="email" name="mail" style="width: 98%"
					value="<%=dto.getMail()%>"></td>
			</tr>
			<tr>
				<td>글 제 목</td>
				<td><input type="text" name="title" style="width: 98%"
					value="<%=dto.getTitle()%>"></td>
			</tr>
			<tr>
				<td>글 내 용</td>
				<td><textarea name="cont" rows="10" style="width: 98%"><%=dto.getCont()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center; height: 50">
				<input type="button" value="수정완료" onclick="check()"> 
				<input type="button" value="목록보기" 
			 		   onclick="location.href='boardlist.jsp?page=<%=bpage%>'"></td>
			</tr>
		</table>
	</form>
</body>
</html>