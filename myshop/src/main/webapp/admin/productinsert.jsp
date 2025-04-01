<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body>
	<%@include file="admin_top.jsp"%>
	<form action="/myshop/product/upload" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" required></td>
			</tr>
			<tr>
				<td>상세정보</td>
				<td><textarea name="detail" rows="5" cols="50" required></textarea></td>
			</tr>
			<tr>
				<td>재고</td>
				<td><input type="text" name="stock" required></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="상품 등록"> 
				<input type="reset" value="다시 입력"></td>
			</tr>
		</table>
	</form>
	<%@include file="admin_bottom.jsp"%>
</body>
</html>