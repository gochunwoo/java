<%@page import="pack.product.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="productManager" class="pack.product.ProductManager" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>

<!-- 💡 셀 정렬을 예쁘게 만들기 위한 스타일 -->
<style>
  table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
  }
  th, td {
    padding: 8px;
    text-align: center;
    border: 1px solid #ccc;
  }
</style>

</head>
<body>
<h2>* 전체 상품 목록 : 관리자 *</h2>
<%@include file="admin_top.jsp" %>

<br>
<a href="productinsert.jsp">[ 상품등록 ]</a>
<table>
   <tr style="background-color: blue; color: white;">
     <th>상품번호</th>
     <th>상품명</th>
     <th>가격</th>
     <th>등록일</th>
     <th>재고량</th>
     <th>상세보기</th>
   </tr>
   <%
   ArrayList<ProductDto> list = productManager.getProductAll();
   if(list.size() == 0){
   %>
   <tr><td colspan="6" style="text-align: center;">등록된 상품이 없습니다</td></tr>  
   <%
   }else{
      for(ProductDto p:list){
   %>
   <tr>
     <td><%=p.getNo() %></td>
     <td><%=p.getName() %></td>
     <td><%=p.getPrice() %></td>
     <td><%=p.getSdate() %></td>
     <td><%=p.getStock() %></td>
     <td>
     	<a href="javascript:productDetail('<%=p.getNo() %>')">보기</a>
     </td>
   </tr>
   <%   
      }
   }
   %>
</table>   

<%@include file="admin_bottom.jsp"%>

<form action="productdetail.jsp" name="detailFrm" method="post">
	<input type="hidden" name="no">
</form>
</body>
</html>
