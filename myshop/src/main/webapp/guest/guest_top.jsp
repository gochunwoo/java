<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- guest_top 은 session 을 읽는 작업을 작성. --%>
    
    <%
    String memid = (String)session.getAttribute("idKey");
    
    String log ="";
    if(memid == null){	// 세션이 없을떄 로그인화면보여주고 있으면 로그아웃화면을 보여준다!!
    	log = "<a href='../member/login.jsp'>로그인</a>";
    }else{
    	log = "<a href='../member/logout.jsp'>로그아웃</a>";
    }
    
    String mem="";
    if(memid == null){
    	mem = "<a href='../member/register.jsp'>회원가입</a>";
    }else{
    	mem = "<a href='../member/memberupdate.jsp'>회원수정</a>";
    }
    %>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <h2>* 쇼핑몰 메뉴 *</h2>
    <table>
    	<tr>
    		<td><%=log%></td>
    		<td><%=mem%></td>
    		<td><a href="productlist.jsp">상품목록</a></td>
    		<td><a href="cartlist.jsp">장바구니</a></td>
    		<td><a href="orderlist.jsp">구매목록</a></td>
    		<td><a href="../board/boardlist.jsp">게시판(QNA)</a></td>
    	</tr>
    </table>