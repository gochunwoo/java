<%@page import="pack.SangpumDto"%>
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
function  funcUpdate(){ // 수정
		let code = prompt("수정할 코드 입력","");
		if(code !== "" && code !== null){	//수정할값이 공백이거나  null이 아닐경우
			location.href="jspex16up.jsp?code=" + code;	
		}
}
function  funcDelete(){// 삭제
	let code = prompt("삭제할 코드 입력","");
	if(code !== "" && code !== null){
		if(confirm("지울 꺼야?"))
		location.href="jspex16del.jsp?code=" + code;
	}
}
</script>
</head>
<body>
<h2>상품 정보(Beans - paging)</h2>
	<a href="jspex16ins.html">추가</a>&nbsp;&nbsp;
	<a href="javascript:funcUpdate()">수정</a>&nbsp;&nbsp;
	<a href="javascript:funcDelete()">삭제</a>&nbsp;&nbsp;
	<br>
	<table border="1">
		<tr>
			<th>코드</th>
			<th>품명</th>
			<th>수량</th>
			<th>단가</th>
		</tr>
		<%
		ArrayList<SangpumDto> slist = dbConnPooling.getDataAll();
				// out.print(slist.size());
				for(SangpumDto s:slist){
		%>
			<tr>
				<td> <%= s.getCode() %> </td>
				<td> <%= s.getSang() %> </td>
				<td> <%= s.getSu() %> </td>
				<td> <%= s.getDan() %> </td>
			</tr>
			<% 
		}
		
		%>
		</table>
</body>
</html>