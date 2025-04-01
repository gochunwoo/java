<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaDto" %>
<%@ page import="pack.qa.QaManager" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />
<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<%
  String no = request.getParameter("no");
  QaDto dto = qaMgr.getData(no);
  request.setAttribute("dto", dto);
%>

<div class="qa-container">
  <h2>질문 수정</h2>
  <form method="post" action="qa_editproc.jsp">
    <input type="hidden" name="publish_no" value="${dto.publish_no}">
    <table class="qa-table">
      <tr>
        <th>이름</th>
        <td><input type="text" name="writer" value="${dto.writer}" required></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="postpassword" value="${dto.postpassword}" required></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" name="title" value="${dto.title}" required></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name="postcontent" rows="10" required>${dto.postcontent}</textarea></td>
      </tr>
      <tr>
        <th>비밀글</th>
        <td>
          <label>
            <input type="checkbox" name="secretYN" value="1" ${dto.secretYN == 1 ? "checked" : ""}> 비밀글로 유지
          </label>
        </td>
      </tr>
    </table>
    <div class="qa-write-button">
      <button type="submit">수정</button>
    </div>
  </form>
</div>
<%@ include file="../include/bottom.jsp" %>
