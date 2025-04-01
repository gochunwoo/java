<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<%
  String no = request.getParameter("no");
%>

<div class="qa-container">
  <h2>비밀글 확인</h2>
  <form method="post" action="qa_checkproc.jsp">
    <input type="hidden" name="no" value="<%= no %>">
    <table class="qa-table">
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="postpassword" required></td>
      </tr>
    </table>
    <div class="qa-write-button">
      <button type="submit">확인</button>
    </div>
  </form>
</div>
<%@ include file="../include/bottom.jsp" %>