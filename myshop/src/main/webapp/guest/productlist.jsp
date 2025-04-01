<%@page import="pack.product.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="productManager" class="pack.product.ProductManager" />

<%
request.setCharacterEncoding("utf-8");
ArrayList<ProductDto> list = productManager.getProductAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객-상품목록</title>
<link href="../css/style.css?v=1.0" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body>

	<h2>* VVIP 롤 전용 스킨 판매점 *</h2>
	<h3>* 어디서든 볼 수 없는 오직 VVIP에게만 제공되는 병맛스킨 *</h3>

	<%@include file="guest_top.jsp"%>

	<!-- 상품 카드 그리드 시작 -->
	<div class="product-grid">
		<%
		for (ProductDto p : list) {
		%>
		<div class="product-card">
			<img src="../upload/<%=p.getImage()%>" alt="상품이미지">
			<h3><%=p.getName()%></h3>
			<p>
				<strong>가격:</strong>
				<%=p.getPrice()%>
				RP
			</p>
			<p>
				<strong>재고:</strong>
				<%=p.getStock()%>
				개
			</p>
			<a href="javascript:porductDetailGuest('<%=p.getNo()%>')"
				class="card-btn">상세 보기</a>
		</div>
		<%
		}
		%>
	</div>
	<!-- 상품 카드 그리드 끝 -->

	<%@include file="guest_bottom.jsp"%>

	<form action="productdetail_g.jsp" name="detailFrm" method="post">
		<input type="hidden" name="no">
	</form>

</body>
</html>
