<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="productManager" class="pack.product.ProductManager" />
<%
request.setCharacterEncoding("utf-8");

ProductDto productDto = productManager.getProduct(request.getParameter("no"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body>
	<%@include file="admin_top.jsp"%>
	
	<form action="/myshop/product/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="<%=productDto.getNo()%>">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" value="<%=productDto.getName()%>"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" value="<%=productDto.getPrice()%>"></td>
			</tr>
			<tr>
				<td>재고</td>
				<td><input type="text" name="stock" value="<%=productDto.getStock()%>"></td>
			</tr>
			<tr>
				<td>상세설명</td>
				<td><textarea name="detail" rows="5" cols="40"><%=productDto.getDetail()%></textarea></td>
			</tr>
			<tr>
				<td>이미지 변경</td>
				<td>
				<img src="../upload/<%=productDto.getImage()%>">
				<input type="file" name="image">
				<input type="hidden" name="currentImage" value="<%=productDto.getImage()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="no" value="<%=productDto.getNo()%>">
				<input type="submit" value="수정 하기">
				<input type="button" value="수정 취소" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>

	<%@include file="admin_bottom.jsp"%>
</body>
</html>