<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="productManager" class="pack.product.ProductManager"></jsp:useBean>

<%
String no = request.getParameter("no");

ProductDto productDto = productManager.getProduct(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 보기</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body>
	<h2>* 상품 상세 보기 *</h2>
	<%@include file="admin_top.jsp"%>
	<table style="width: 95%;">
		<tr>
			<td><img src="../upload/<%=productDto.getImage()%>" width="200" />
			<br><br>
			</td>
			<td>
				<table>
					<tr>
						<td>번호</td>
						<td><%=productDto.getNo()%></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><%=productDto.getName()%></td>
					</tr>
					<tr>
						<td>가격</td>
						<td><%=productDto.getPrice()%></td>
					</tr>
					<tr>
						<td>등록일</td>
						<td><%=productDto.getSdate()%></td>
					</tr>
					<tr>
						<td>재고량</td>
						<td><%=productDto.getStock()%></td>
					</tr>
				</table>
			</td>
			<td><b>* 상품 설명 *</b><br> <%=productDto.getDetail()%></td>
		</tr>
	</table>
	<br>
	<a href="javascript:productUpdate('<%=productDto.getNo()%>')">수정하기</a>  
	<a href="javascript:productDelete('<%=productDto.getNo()%>')">삭제하기</a>
	<%@include file="admin_bottom.jsp"%>

	<form action="productupdate.jsp" name="updateFrm" method="post">
		<input type="hidden" name="no">
	</form>

	<form action="productdelete.jsp" name="delFrm" method="post">
		<input type="hidden" name="no">
	</form>
</body>
</html>