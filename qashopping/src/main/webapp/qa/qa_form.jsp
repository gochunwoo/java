<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaBean" %>
<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<div class="qa-container">
  <h2>질문 작성</h2>
  <form method="post" action="qa_formproc.jsp">
    <table class="qa-table">
      <tr>
        <th>이름</th>
        <td><input type="text" name="writer" required></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="postpassword" required></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" name="title" required></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name="postcontent" rows="10" required></textarea></td>
      </tr>
      <tr>
        <th>비밀글</th>
        <td>
          <label><input type="checkbox" name="secretYN" value="1"> 비밀글로 등록</label>
        </td>
      </tr>
    </table>
    <div class="qa-write-button">
      <button type="submit">등록</button>
    </div>
  </form>
</div>
<%@ include file="../include/bottom.jsp" %>