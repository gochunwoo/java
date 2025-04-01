<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaDto" %>
<%@ page import="pack.qa.QaManager" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />
<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<%
    String no = request.getParameter("no");
    QaDto dto = qaMgr.getReplyData(no);
    request.setAttribute("dto", dto);
    request.setAttribute("no", no);
%>

<div class="qa-container">
  <h2>답변 작성</h2>
  <form method="post" action="qa_replyproc.jsp">
    <input type="hidden" name="publish_no" value="${no}">
    <table class="qa-table">
      <tr>
        <th>제목</th>
        <td><input type="text" name="title" value="RE: ${dto.title}" readonly></td>
      </tr>
      <tr>
        <th>답변 내용</th>
        <td><textarea name="replycontent" rows="10" required></textarea></td>
      </tr>
    </table>
    <div class="qa-write-button">
      <button type="submit">답변 등록</button>
    </div>
  </form>
</div>
<%@ include file="../include/bottom.jsp" %>