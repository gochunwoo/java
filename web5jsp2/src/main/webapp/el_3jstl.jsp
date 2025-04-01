<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
 <link rel='stylesheet' type='text/css' href='css/css.css'>
</head>
<body>
	JSTL(java Standard Tag Library) : 변수, 제어문 사용이 가능. 일반적으로 EL과 함께 사용
	<hr>
	** 변수 처리 **
	<br>
	<c:set var="irum" value="공기밥" scope="page" />	<%-- 변수설정할떄 set --%>
	이름 :
	<c:out value="${irum }" />

	<c:set var="ir" scope="session">
주먹밥
</c:set>
	<br> 이름2 :
	<c:out value="${ir}" />
	<br>
	<c:remove var="irum" scope="session" /> <%-- 스코프 영역이 달라야됨 --%>
	이름1 : <c:out value="${irum}" />		<%-- 변수제거할떄 remove --%>
	<br>
	<c:remove var="irum" scope="page"/>
	이름1 : <c:out value="${irum}" />
	<br>
	<c:remove var="irum" scope="page"/>
	이름1 : <c:out value="${irum}" />
	<br>
	<c:set var="abc" value="${header['User-Agent']}"></c:set>
	현재 사용 중인 브라우저 정보 : <c:out value="${abc}"></c:out>
	<br>
	<c:set var="su1" value="10" />
	<c:set var="su2" value="20" />
	합은 : ${su1 + su2 }
	<hr>
	** 조건 판단문 **
	<c:set var="nice" value="star" />
	<c:if test="${nice == 'star'}">	<%-- nice == 'star' 또는 nice eq 'star' --%>
	<br>
	if 연습 : nice 값은 <c:out value="${nice}" />
	</c:if>
	<c:if test="${nice != 'star'}">	<%-- else 역할 --%>
	</c:if>
	<br>
	if 연습 : nice 값은 <c:out value="${nice}" />
	<br>
	** 조건 판단문 choose ** <br>
	<c:choose>
		<c:when test="${nice == 'moon' }">
		 달	<c:out value="${nice }" />
		</c:when>
		<c:when test="${nice == 'star' }">
		 별	<c:out value="${nice }" />
		</c:when>
	</c:choose>
	<br>
	** 반복문 forEach **
	연습1 : 
	<c:forEach var="i" begin="1" end="10" step="2">
		${i}&nbsp;
	</c:forEach>
	<br>
	연습1-1 구구단 3단 출력 :
	<c:forEach var="su" begin="1" end="9">
		3X${su}=${3 * 1}&nbsp;
	</c:forEach>
	
	<br>
	연습2(header 내장 객체 값 출력) :
	<c:forEach var="h" items="${headerValues}">
		속성 : ${h.key}<br>
		값 : 
		<c:forEach var="a" items="${h.value}">
			${a}&nbsp;
		</c:forEach>
	</c:forEach>
	<br><br>
	<%
	HashMap<String, Object> map = new HashMap<>();
	map.put("name", "손오공");
	map.put("today", new Date());
	%>
	%>
	<c:set var="m" value="<%= map %>"></c:set>
	<c:forEach var="kk" items="${m}">
    ${kk.key} : ${kk.value}<br>
	</c:forEach>
	<br>
	배열 생성 후 출력<br>
	<c:set var="arr" value="<%= new int[]{1,2,3,4,5} %>" />
	<c:forEach var="j" items="${arr}">``
    ${j}&nbsp;
	</c:forEach>
	<br>
	<br>
	List 컬렉션 자료 반복 출력 <br>
	<%
	List<String> names = new ArrayList<>();
	names.add("유비");
	names.add("관우");
	names.add("장비");
	request.setAttribute("names",names);
	%>
	<c:forEach var="n" items="${names}">
		이름 : ${n}&nbsp;&nbsp;
	</c:forEach>
	
	<br><br>
	* 문자열 분항 후 출력 * <br>
	<c:forTokens var="animal" items="horse,dog,cat,tiger,lion" delims=",">
		동물 : ${animal}&nbsp;&nbsp;
	</c:forTokens>
	<br>
	<c:forTokens var="city" items="서울,인천,수원,원주*춘천,제주" delims=",*" varStatus="num">
		${num.count}. ${num.index})  ${city}&nbsp;&nbsp;
	</c:forTokens>
	<hr>
	* 숫자 및 날짜 서식 *<br>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	숫자1 : <fmt:formatNumber value="12345.678" type="number" /><br>
	숫자2 : <fmt:formatNumber value="12345.678" type="currency" /><br>
	숫자3 : <fmt:formatNumber value="12345.678" type="percent" /><br>
	숫자4 : <fmt:formatNumber value="12.678" pattern="0,000.0" /><br>
	숫자5 : <fmt:formatNumber value="12.678" pattern="#,##0.0" /><br>
	숫자6 : <fmt:formatNumber value="0" pattern="0,000.0" /><br>
	숫자7 : <fmt:formatNumber value="0" pattern="#,##0.0" /><br>
	숫자8 : <fmt:formatNumber value="0" pattern="#,###.#" /><br>
	<br>
	* 날짜 , 시간 표시 *
	<br>
	<c:set var="now" value="<%=new Date() %>"/>
	<c:out value="${now}"/><br>
	날짜 : <fmt:formatDate value="${now}" type="date" /><br>
	시간 : <fmt:formatDate value="${now}" type="time" /><br>
	모두 : <fmt:formatDate value="${now}" type="both" /><br>
	모두 : <fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" /><br>
	
	
</body>
</html>