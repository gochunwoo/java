<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaManager" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />
<%
    request.setCharacterEncoding("UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    String inputPass = request.getParameter("postpassword");
    boolean check = qaMgr.checkPassword(no, inputPass);
    if (check) {
        response.sendRedirect("qa_detail.jsp?no=" + no);
    } else {
%>
        <script>
            alert("비밀번호가 일치하지 않습니다.");
            history.back();
        </script>
<%
    }
%>