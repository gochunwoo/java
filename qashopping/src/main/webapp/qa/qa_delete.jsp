<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaManager" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />
<%
    String no = request.getParameter("no");
    qaMgr.delData(no);
    response.sendRedirect("qa_list.jsp");
%>