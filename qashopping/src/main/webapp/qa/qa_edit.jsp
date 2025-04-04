<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaManager, pack.qa.QaDto" %>
<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css?v=mintclean">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

<%
    request.setCharacterEncoding("UTF-8");
    String no = request.getParameter("no");
    String inputPw = request.getParameter("postpassword");

    QaManager mgr = new QaManager();
    QaDto dto = mgr.getData(no);

    if (inputPw == null || !inputPw.equals(dto.getPostpassword())) {
%>
<script>
    alert("비밀번호가 일치하지 않습니다.");
    history.back();
</script>
<%
        return;
    }

    String content = dto.getPostcontent();
    String imageFileName = "";
    if (content != null && content.contains("/upload/")) {
        int start = content.indexOf("/upload/") + 8;
        int end = content.indexOf("\"", start);
        if (start > 0 && end > start) {
            imageFileName = content.substring(start, end);
        }
    }

    String cleanedContent = content.replaceAll("<img[^>]*>", "").replaceAll("<br>", "\n");
%>

<div class="qa-container">
  <h2 class="qa-title"><i class="bi bi-pencil-square"></i> 글 수정</h2>

  <form method="post" action="QaUploadEditServlet" class="qa-form" enctype="multipart/form-data">
    <input type="hidden" name="no" value="<%= dto.getPublish_no() %>">
    <input type="hidden" name="currentImage" value="<%= imageFileName %>">

    <div class="mb-4">
      <label for="writer" class="form-label">작성자</label>
      <input type="text" class="form-control" name="writer" value="<%= dto.getWriter() %>" required>
    </div>

    <div class="mb-4">
      <label for="postpassword" class="form-label">비밀번호</label>
      <input type="password" class="form-control" name="postpassword" value="<%= dto.getPostpassword() %>" required>
    </div>

    <div class="mb-4">
      <label for="title" class="form-label">제목</label>
      <input type="text" class="form-control" name="title" value="<%= dto.getTitle() %>" required>
    </div>

    <div class="mb-4">
      <label for="postcontent" class="form-label">내용</label>
      <textarea class="form-control" name="postcontent" rows="10" required><%= cleanedContent %></textarea>
    </div>

    <div class="mb-4">
      <label for="image" class="form-label">이미지 첨부</label>
      <input type="file" class="form-control" name="image" accept="image/*">
    </div>

    <div class="form-check mb-4">
      <input class="form-check-input" type="checkbox" name="secretYN" value="1" <%= dto.getSecretYN() == 1 ? "checked" : "" %>>
      <label class="form-check-label">비밀글 설정</label>
    </div>

    <div class="qa-button-group">
      <button type="submit" class="btn btn-dark"><i class="bi bi-check-lg"></i> 수정 완료</button>
      <button type="button" class="btn btn-outline-secondary" onclick="location.href='qa_detail.jsp?no=<%= dto.getPublish_no() %>'">취소</button>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/qa.js"></script>
<%@ include file="../include/bottom.jsp" %>