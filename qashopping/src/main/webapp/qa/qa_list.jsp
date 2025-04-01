<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="pack.qa.QaManager" %>
<%@ page import="pack.qa.QaDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />

<%
    request.setCharacterEncoding("UTF-8");
    String searchType = request.getParameter("searchType");
    String searchWord = request.getParameter("searchWord");
    String pageStr = request.getParameter("page");
    int currentPage = (pageStr == null || pageStr.equals("")) ? 1 : Integer.parseInt(pageStr);

    qaMgr.totalList();
    int recTot = qaMgr.getRecTot();
    int pageSu = qaMgr.getPageSu();
    java.util.List<pack.qa.QaDto> list = qaMgr.getDataAll(currentPage, searchType, searchWord);
    request.setAttribute("list", list);
    request.setAttribute("pageSu", pageSu);
    request.setAttribute("recTot", recTot);
    request.setAttribute("searchType", searchType);
    request.setAttribute("searchWord", searchWord);
    request.setAttribute("currentPage", currentPage);
%>

<%@ include file="../include/top.jsp" %>
<link rel="stylesheet" href="../css/qa.css">

<div class="qa-container">
    <h2>질문과답변</h2>

    <!-- 검색창 -->
    <form method="post" action="qa_list.jsp" class="qa-search-form">
        <label><input type="radio" name="searchType" value="writer" ${searchType eq 'writer' ? 'checked' : ''}> 이름</label>
        <label><input type="radio" name="searchType" value="title" ${(searchType eq null or searchType eq 'title') ? 'checked' : ''}> 제목</label>
        <label><input type="radio" name="searchType" value="postcontent" ${searchType eq 'postcontent' ? 'checked' : ''}> 내용</label>
        <input type="text" name="searchWord" value="${searchWord != null ? searchWord : ''}">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>

    <!-- 게시판 테이블 -->
    <table class="qa-table">
        <thead>
            <tr>
                <th>NO.</th>
                <th>CONTENT</th>
                <th>NAME</th>
                <th>DATE</th>
                <th>HITS</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dto" items="${list}" varStatus="loop">
                <tr>
                    <td>${recTot - ((currentPage - 1) * 5 + loop.index)}</td>
                    <td>
                        <c:if test="${dto.secretYN == 1}">
                            <img src="../img/lock.png" width="13">
                        </c:if>
                        <form method="post" action="${dto.secretYN == 1 ? 'qa_check.jsp' : 'qa_detail.jsp'}">
                            <input type="hidden" name="no" value="${dto.publish_no}" />
                            <button type="submit" class="title-btn">${dto.title}</button>
                        </form>
                    </td>
                    <td>${fn:substring(dto.writer, 0, 1)}*${fn:substring(dto.writer, fn:length(dto.writer) - 1, fn:length(dto.writer))}</td>
                    <td>${dto.postcreatedate}</td>
                    <td>0</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- 페이지 번호 -->
    <div class="qa-pagination">
        <form method="post" action="qa_list.jsp">
            <input type="hidden" name="searchType" value="${searchType}">
            <input type="hidden" name="searchWord" value="${searchWord}">
            <c:forEach var="i" begin="1" end="${pageSu}">
                <button type="submit" name="page" value="${i}" class="${i == currentPage ? 'active' : ''}">${i}</button>
            </c:forEach>
        </form>
    </div>

    <!-- 글쓰기 버튼 -->
    <div class="qa-write-button">
        <form method="post" action="qa_form.jsp">
            <button type="submit">WRITE</button>
        </form>
    </div>
</div>

<script src="../js/qa.js"></script>
<%@ include file="../include/bottom.jsp" %>