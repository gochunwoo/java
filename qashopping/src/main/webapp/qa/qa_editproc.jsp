<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaBean" %>
<%@ page import="pack.qa.QaManager" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />
<jsp:useBean id="bean" class="pack.qa.QaBean" />

<%
    request.setCharacterEncoding("UTF-8");
    bean.setPublish_no(Integer.parseInt(request.getParameter("publish_no")));
    bean.setWriter(request.getParameter("writer"));
    bean.setPostpassword(request.getParameter("postpassword"));
    bean.setTitle(request.getParameter("title"));
    bean.setPostcontent(request.getParameter("postcontent"));
    bean.setPostcreatedate();
    bean.setSecretYN(request.getParameter("secretYN") == null ? 0 : 1);
    bean.setAdminid(null);
    bean.setReplycontent(request.getParameter("replycontent") == null ? null : request.getParameter("replycontent"));
    bean.setReplyday(request.getParameter("replyday") == null ? null : request.getParameter("replyday"));

    qaMgr.saveEdit(bean);
    response.sendRedirect("qa_detail.jsp?no=" + bean.getPublish_no());
%>