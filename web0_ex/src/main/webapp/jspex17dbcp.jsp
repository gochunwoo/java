<%@page import="pack.GuestbookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/css.css'>
<script type="text/javascript">
	function funcUpdate(code) { // 수정
		
		if (code !== "" && code !== null) { //수정할값이 공백이거나  null이 아닐경우
			location.href = "jspex17up.jsp?code=" + code;
		}
	}
	function funcDelete(code) {	// 삭제
		if (code !== "" && code !== null) {
			if(confirm("지울 꺼야?"))
				location.href = "jspex17del.jsp?code=" + code;
		}
	}
</script>
</head>
<body>
	<h2>방명록 정보(Beans - paging)</h2>
	<a href="jspex17ins.html">글쓰기</a>&nbsp;&nbsp;
	<br>
	<table border="1">
		<tr>
			<th>코드</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<%
		ArrayList<GuestbookDto> slist = dbConnPooling.getDataAll();
		// out.print(slist.size());
		for (GuestbookDto s : slist) {
		%>
		<tr>
			<td><a href="javascript:funcDelete(<%=s.getCode()%>)"><%=s.getCode()%></a></td>
			<td><a href="javascript:funcUpdate(<%=s.getCode()%>)"><%=s.getWriter()%></a></td>
			<td><%=s.getTitle()%></td>
			<td><%=s.getContents()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>