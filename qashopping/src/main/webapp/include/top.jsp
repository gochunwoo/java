<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Odeur</title>

    <!-- ✅ CSS 상대경로 유지 -->
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

    <!-- ✅ 상단 헤더 -->
    <header class="main-header">
        <div class="header-left"></div>
        <div class="logo-area">Odeur</div>
        <div class="icon-menu">
            <i class="fa fa-search" title="검색" onclick="toggleSlideSearch()"></i>

            <div class="icon-dropdown-wrapper">
                <i class="fa fa-user" title="마이페이지 / 로그인"></i>
                <div class="icon-dropdown-menu">
                    <strong>로그인/회원가입</strong>
                    <ul>
                        <li><a href="#">- 로그인</a></li>
                        <li><a href="#">- 회원가입</a></li>
                        <li><a href="#">- 주문목록/배송조회</a></li>
                    </ul>
                </div>
            </div>

            <i class="fa fa-shopping-cart" title="장바구니"></i>
        </div>
    </header>

    <!-- ✅ 내비게이션 메뉴 -->
    <nav class="nav-bar">
        <ul class="nav-list">
            <li><a href="#">신상품</a></li>
            <li class="has-dropdown">
                <a href="#">추천순</a>
                <ul class="dropdown-menu">
                    <li><a href="#">남성</a></li>
                    <li><a href="#">여성</a></li>
                </ul>
            </li>
            <li class="has-dropdown">
                <a href="#">향기순</a>
                <ul class="dropdown-menu">
                    <li><a href="#">Top</a></li>
                    <li><a href="#">Middle</a></li>
                    <li><a href="#">Base</a></li>
                </ul>
            </li>
            <!-- ✅ Q&A 경로 유지 -->
            <li><a href="../qa/qa_list.jsp">Q&A</a></li>
        </ul>
    </nav>

    <!-- ✅ 슬라이드 검색창 -->
    <div id="slide-search" class="slide-search">
        <i class="fa fa-times close-btn" onclick="toggleSlideSearch()"></i>
        <input type="text" placeholder="원하시는 향수를 찾아보세요" />
        <button type="button"><i class="fa fa-search"></i></button>
    </div>

    <!-- ✅ 검색창 슬라이드 토글 스크립트 -->
    <script>
        function toggleSlideSearch() {
            const search = document.getElementById("slide-search");
            search.classList.toggle("active");
        }
    </script>

</body>
</html>
