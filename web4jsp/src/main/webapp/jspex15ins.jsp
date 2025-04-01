<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // 용도 : 수신된 입력자료를 DB 저장 후 상품정보 보기 창으로 이동
    request.setCharacterEncoding("utf-8");
    // String sang = request.getParameter("sang");....
    
    // 폼빈사용
    
    %>
    <jsp:useBean id="dbConnPaging" class="pack.DbConnPaging" />
	    
    <jsp:useBean id="formBean" class="pack.SangpumFormBean" />
    <jsp:setProperty property="*" name="formBean"/>
    <%-- 자바에서도 입력자료 검사 권장 --%>
    <%
    if(formBean.getSang().equals("") || formBean.getSang() == null){	// sang su dan
    	response.sendRedirect("jspex15insert.html");
    	return;
    }
    
    dbConnPaging.sangpumInsert(formBean);
    
    // 상품 추가 후 목록보기로 이동 : forward 하면안됨 데이터가 반복적으로 계속생성됨
    // request.getRequestDispatcher("jspex15paging.jsp").forward(request, response); // 포딩처리x
    
      // 상품추가후 목록으로보기 이동 : redirect  // 추가 삭제 업데이후에는 무조건  redirect 처리 필수
     response.sendRedirect("jspex15paging.jsp");
    
    %>
    
    
    
    
    
    
    
    
    
    
    
    
<link rel='stylesheet' type='text/css' href='css/css.css'>