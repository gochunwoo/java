<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");  %>

<jsp:useBean id="bean" class="pack.board.BoardBean" />
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardManager" class="pack.board.BoardManager" />

<% 
String bpage = request.getParameter("page");
// num 은 frombean 을 타고 넘어왔음

//비밀번호 비교 후 수정 여부 결정
boolean b = boardManager.checkPassword(bean.getNum(), bean.getPass());	// 비번비교

if(b){
	boardManager.saveEdit(bean);
	response.sendRedirect("boardlist.jsp?page=" + bpage);	// 수정후 목록보기
}else{
	%>
	<script>
		alert("비밀번호가 불일치 합니다");
		history.back();
	</script>
	<%
}

%>