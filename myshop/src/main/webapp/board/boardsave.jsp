<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");  %>
<link rel="stylesheet" type="text/css" href="../css/css.css">

<jsp:useBean id="bean" class="pack.board.BoardBean" />
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardManager" class="pack.board.BoardManager"/>

<%
int newNum = boardManager.currentMaxNum() + 1;
bean.setNum(newNum);
bean.setBip(request.getRemoteAddr());	// 긁을 입력한 사람의 주소
bean.setBdate();
bean.setGnum(newNum);	// 원글인 경우 ...

boardManager.saveData(bean);

response.sendRedirect("boardlist.jsp?page=1");

%>

