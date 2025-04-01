<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");  %>
<link rel="stylesheet" type="text/css" href="../css/css.css">

<jsp:useBean id="bean" class="pack.board.BoardBean" />
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardManager" class="pack.board.BoardManager"/>

<%
String bpage = request.getParameter("page");

// 폼빈 내용 채우기
int num = bean.getNum();
int gnum = bean.getGnum();
int onum = bean.getOnum() + 1;
int nested = bean.getNested() + 1;


boardManager.updateOnum(gnum, onum);	// 기존 댓글 정렬 조정
bean.setOnum(onum);		// 새댓글 onum 설정
bean.setNested(nested);	// 들여쓰기 단계 설정

bean.setBip(request.getRemoteAddr());	// 사용자 IP
bean.setBdate();	// 오늘날짜
bean.setNum(boardManager.currentMaxNum() + 1);	// 새 글번호

boardManager.saveReplyData(bean);

response.sendRedirect("boardlist.jsp?page=" + bpage);	// 댓글 추가후 목록보기

%>
