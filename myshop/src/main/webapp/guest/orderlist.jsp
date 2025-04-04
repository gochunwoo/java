<%@page import="pack.product.ProductDto"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="orderManager" class="pack.order.OrderManager" />
<jsp:useBean id="productManager" class="pack.product.ProductManager" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
<link href="../css/style.css?v=1.0" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
	<h2>* 주문 상품 목록 *</h2>
	<%@include file="guest_top.jsp"%>
	<table>
		<tr>
			<th>주문번호</th>
			<th>상품명</th>
			<th>주문수량</th>
			<th>주문일자</th>
			<th>주문상태</th>
		</tr>
		<%
		String id = (String) session.getAttribute("idKey");
		ArrayList<OrderBean> list = orderManager.getOrder(id);

		if (list.isEmpty()) {
		%>
		<tr>
			<td>주문한 상품이 없습니다.</td>
		</tr>
		<%
		} else {
		for (OrderBean order : list) {
			ProductDto product = productManager.getProduct(order.getProduct_no());
		%>
		<tr>
			<td><%=order.getNo() %></td>
			<td><%=product.getName() %></td>
			<td><%=order.getQuantity() %></td>
			<td><%=order.getSdate() %></td>
			<td>
			<%-- <%=order.getState() --%>
			<%
			switch(order.getState()){
				case "1":out.println("접수되었습니다.");break;
				case "2":out.println("입금이확인되었습니다.");break;
				case "3":out.println("배송준비되었습니다.");break;
				case "4":out.println("배송중입니다.");break;
				case "5":out.println("처리가 완료되었습니다.");break;
				default:out.println("접수되었습니다.");
			}
			%>
			</td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<%@include file="guest_bottom.jsp"%>
</body>
</html>