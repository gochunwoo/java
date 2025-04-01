<%@page import="pack.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pack.board.BoardManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="boardManager" class="pack.board.BoardManager" />
<jsp:useBean id="dto" class="pack.board.BoardDto" />
<%
int pageSu, bpage = 1; // page는 예약어이므로 bpage
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/css.css">

<script type="text/javascript">
	window.onload = () => {
		document.querySelector("#btnSearch").onclick = function(){
			if(frm.searchWord.value === ""){
				// frm.searchWord.focus();
				frm.searchWord.placeholder="검색어를 입력하세요.";
				return;
			}
			frm.submit();
		}
	}
	</script>
</head>
<body>
	<table>
		<tr>
			<td><div class="nav-links">
  <a href="../guest/guest_index.jsp">메인 페이지</a>
  <a href="boardlist.jsp?page=1">최근 목록</a>
  <a href="boardwrite.jsp">새글 작성</a>
  <a href="#" onclick="window.open('admin.jsp','','width=600,height=400,top=200,left=300')">관리자용</a>

</div>
 <br> <br>
				<table style="width: 100%">
					<tr style="background-color: cyan;">
						<th>번호</th>
						<th>글 제 목</th>
						<th>작 성 자</th>
						<th>등 록 일</th>
						<th>조 회 수</th>
					</tr>
					<%
					request.setCharacterEncoding("utf-8");

					try {
						bpage = Integer.parseInt(request.getParameter("page"));
					} catch (Exception e) {
						bpage = 1;
					}
					if (bpage <= 0)
						bpage = 1;

					String searchType = request.getParameter("searchType"); // 검색처리
					String searchWord = request.getParameter("searchWord"); // 검색처리

					boardManager.totalList(); // 전체 레코드 수 구하기
					pageSu = boardManager.getPageSu(); // 전체 페이지 수 얻기

					// ArrayList<BoardDto> list = boardManager.getDataAll(bpage);
					ArrayList<BoardDto> list = boardManager.getDataAll(bpage, searchType, searchWord);

					for (int i = 0; i < list.size(); i++) {
						dto = list.get(i);
						
						// 댓글 들여쓰기 준비
						int nst = dto.getNested();
						String tab = "";
						for(int k = 0; k < nst; k++){
							tab += "&nbsp;&nbsp;";
						}
					%>
					<tr>
						<td><%=dto.getNum()%></td>
						<td>
						<%=tab %><a href="boardcontent.jsp?num=<%=dto.getNum()%>&page=<%=bpage%>"><%=dto.getTitle()%></a>
						</td>
						<td><%=dto.getName()%></td>
						<td><%=dto.getBdate()%></td>
						<td><%=dto.getReadcnt()%></td>
					</tr>

					<%
					}
					%>
				</table> <br>
				<table style="width: 100%">
					<tr>
						<td style="text-align: center;">
							<%
							for (int i = 1; i <= pageSu; i++) {
								if (i == bpage) {
									out.print("<a class='page-btn active' href='boardlist.jsp?page=" + i + "'>" + i + "</a>");
								} else {
									out.print("<a class='page-btn' href='boardlist.jsp?page=" + i + "'>" + i + "</a>");
								}
							}
							%> <br> <br>
							<form action="boardlist.jsp" name="frm" method="post">
								<div class="select-wrapper">
									<select name="searchType">
										<option value="title" selected="selected">글 제 목</option>
										<option value="name">작 성 자</option>
									</select>
								</div>
								<input type="text" name="searchWord"> <input
									type="button" value="검색" id="btnSearch">
							</form>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>