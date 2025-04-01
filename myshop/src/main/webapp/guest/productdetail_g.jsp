<%@page import="pack.product.ProductManager"%>
<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="productManager" class="pack.product.ProductManager" />

<%
String no = request.getParameter("no");
ProductDto productDto = productManager.getProduct(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<link rel="stylesheet" type="text/css" href="../css/style.css?v=1.0">
</head>
<body>
<%@include file="guest_top.jsp"%>

<div class="product-detail-container">
  <form action="cartproc.jsp" method="post">
    <div class="product-card">
      <!-- 이미지 -->
      <div class="product-img">
        <img src="../upload/<%=productDto.getImage()%>" alt="상품이미지">
      </div>

      <!-- 상품 정보 -->
      <div class="product-info">
        <h2><%=productDto.getName()%></h2>
        <p><strong>상품번호: </strong> [ <%=productDto.getNo()%> ]</p>
        <p><strong>가격: </strong> [ <%=productDto.getPrice()%> 원 ]</p>
        <p><strong>등록일: </strong> [ <%=productDto.getSdate()%> ]</p>
        <p><strong>재고수량: </strong> [ <%=productDto.getStock()%>개 ]</p>

        <label for="qty">주문 수량:</label>
        <input type="number" name="quantity" id="qty" value="1" min="1">

        <div class="product-buttons">
        <input type="hidden" name="product_no" value="<%= productDto.getNo()%>">
          <input type="submit" value="장바구니 담기" class="btn">
          <button type="button" class="btn" onclick="history.back()">이전으로 이동</button>
        </div>
      </div>
    </div>

    <!-- 상품 설명 -->
    <div class="product-description">
      <h3>* 상품 설명 *</h3>
      <p><%=productDto.getDetail()%></p>
    </div>
  </form>
</div>

<%@include file="guest_bottom.jsp"%>
</body>
</html>
