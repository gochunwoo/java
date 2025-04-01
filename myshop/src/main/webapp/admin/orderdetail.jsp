<%@page import="pack.product.ProductDto"%>
<%@page import="pack.order.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderManager" class="pack.order.OrderManager" />    
<jsp:useBean id="productManager" class="pack.product.ProductManager" />

<%
OrderBean order = orderManager.getOrderDetail(request.getParameter("no"));
ProductDto product = productManager.getProduct(order.getProduct_no());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 주문관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body>
<%@include file="admin_top.jsp"  %>
<h2>* 개별 주문 상세보기 *</h2>
<form action="orderproc_admin.jsp" name="detailFrm" method="post">
	<table>
		<tr>
			<td>고객 아이디 : <%=order.getId() %></td>
			<td>주문 번호 : <%=order.getNo() %></td>
			<td>상품 번호 : <%=product.getNo() %></td>
			<td>상품 명 : <%=product.getName() %></td>
		</tr>
		<tr>
			<td>상품 가격 : <%=product.getPrice() %></td>
			<td>주문 수량 : <%=order.getQuantity() %></td>
			<td>재고 수량 : <%=product.getStock() %></td>
			<td>주문 일자 : <%=order.getSdate() %></td>
		</tr>
		<tr>
			<td colspan="4"> 총 결제 금액 : <%= Integer.parseInt(order.getQuantity()) * Integer.parseInt(product.getPrice()) %>원</td>
		</tr>
		<tr>
			<td colspan="4">
				<b>
				주문 상태 :
				<select name="state">
					<option value="1">접수</option>
					<option value="2">입급 확인</option>
					<option value="3">배송 준비</option>
					<option value="4">배송 중</option>
					<option value="5">처리 완료</option>
				</select>
				<script type="text/javascript">
					document.detailFrm.state.value = <%=order.getState()%>
				</script>
				</b>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="상태 수정 " onclick="orderUpdate(this.form)">
				<input type="button" value="상태 삭제 " onclick="orderDelete(this.form)">
				<input type="hidden" name="no" value="<%=order.getNo() %>">
				<input type="hidden" name="flag">
			</td>
		</tr>
	</table>
</form>
<%@include file="admin_bottom.jsp" %>
</body>
</html>