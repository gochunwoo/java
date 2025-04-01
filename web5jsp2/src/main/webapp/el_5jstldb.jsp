<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL의 SQL을 사용해 상품자료 읽기</h2>

<c:catch var="dbErr">
 <sql:setDataSource var="ds"
      driver="org.mariadb.jdbc.Driver"
      url="jdbc:mariadb://localhost:3306/test"
      user="root"
      password="123" />
      
 <sql:query dataSource="${ds}" var="result">
      SELECT * FROM sangdata WHERE code >= ? AND code <= ?
      <sql:param value="1"/>
      <sql:param value="5"/>
 </sql:query>

 <table border="1">
   <tr>
      <th>코드</th>
      <th>품명</th>
      <th>수량</th>
      <th>단가</th>
   </tr>
   <c:forEach var="row" items="${result.rows}">
      <tr>
         <td>${row.code}</td>
         <td>${row.sang}</td>
         <td>${row.su}개</td>
         <td>${row.dan}원</td>
      </tr>
   </c:forEach>
 </table>
</c:catch>

<c:if test="${dbErr != null}">
   <p style="color:red;">DB 처리중 에러 발생 : ${dbErr.message}</p>
</c:if>

</body>
</html>
