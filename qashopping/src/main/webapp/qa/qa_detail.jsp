<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaManager" %>
<%@ page import="pack.qa.QaDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />

<%
    request.setCharacterEncoding("UTF-8");
    String no = request.getParameter("no");
    QaDto dto = qaMgr.getData(no);
    request.setAttribute("dto", dto);
%>

<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<div class="qa-container">
    <h2>질문 상세보기</h2>

    <table class="qa-table">
        <tr>
            <th>제목</th>
            <td>${dto.title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>
                <c:choose>
                    <c:when test="${fn:length(dto.writer) == 1}">
                        ${dto.writer}
                    </c:when>
                    <c:when test="${fn:length(dto.writer) == 2}">
                        ${fn:substring(dto.writer, 0, 1)}*
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(dto.writer, 0, 1)}*${fn:substring(dto.writer, fn:length(dto.writer) - 1, fn:length(dto.writer))}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${dto.postcreatedate}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td style="height: 200px; text-align: left; padding: 20px;">${dto.postcontent}</td>
        </tr>
        <c:if test="${not empty dto.replycontent}">
            <tr>
                <th>답변</th>
                <td style="background-color: #f9f9f9; text-align: left; padding: 20px;">
                    ${dto.replycontent}<br><br>
                    <small style="float: right;">답변일 : ${dto.replyday}</small>
                </td>
            </tr>
        </c:if>
    </table>

    <!-- 버튼 영역 -->
    <div class="qa-button-group">
        <form method="post" action="qa_list.jsp">
            <button type="submit">LIST</button>
        </form>

        <form method="post" action="qa_form.jsp">
            <button type="submit">WRITE</button>
        </form>

        <form method="post" action="qa_edit.jsp">
            <input type="hidden" name="no" value="${dto.publish_no}">
            <button type="submit">EDIT</button>
        </form>

        <form method="post" action="qa_reply.jsp">
            <input type="hidden" name="no" value="${dto.publish_no}">
            <button type="submit">REPLY</button>
        </form>

        <form method="post" action="qa_delete.jsp">
            <input type="hidden" name="no" value="${dto.publish_no}">
            <button type="submit">DELETE</button>
        </form>
    </div>
</div>

<%@ include file="../include/bottom.jsp" %>
