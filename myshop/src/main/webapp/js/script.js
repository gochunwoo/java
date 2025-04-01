function zipCheck() {
	let url = "zipcheck.jsp?check=y";
	window.open(url, "post",
		"toolbar=no, whidth=500,height=400,top=200,left=100,status=yes,scrollbars=yes,munubar=no");

}

function idCheck() {
	if (regForm.id.value === "") {
		alert("ID 를 입력하세요");
		regForm.id.focus();
	} else {
		const url = "idcheck.jsp?id=" + regForm.id.value;
		window.open(url, "id",
			"toolbar=no, whidth=300,height=150,top=200,left=100");

	}
}

function inputCheck() {
	// 입력자료 검사후 서버로 전송
	if(regForm.id.value === ""){
		alert("아이디를 입력하세요");
		regForm.id.focus();
		return;
	}
	// 이하 생략........
	
	regForm.submit();
}
// 회원 로그인 관련
function funcLogin(){
	if(loginForm.id.value === ""){
		alert("회원 아이디 입력");
		loginForm.id.focus();
		
	}else if(loginForm.passwd.value === ""){
		alert("회원 비밀번호 입력")
		loginForm.passwd.focus();
	}else{
		loginForm.action = "loginproc.jsp";
		loginForm.method ="post";
		loginForm.submit();
	}
	
}

function  funcNewMember(){
	location.href = "register.jsp"

}

// 쇼핑몰 로그인 후 자신의 정보 수정
function memberUpdate(){
	// 입력자료 오류검사 ...
	alert( "a")
	document.updateForm.submit();
	
}
function memberUpdateCancel(){
	// 입력자료 오류검사 ...
	location.href="../guest/guest_index.jsp";
	
}
function memberDelete(){
	alert("정말 회원탈퇴를 하시겟습니까?");
	
	
}

// 관리자 관련
function funcAdminLogin(){
   if(adminLoginForm.admin_id.value === ''){
      alert("관리자 id를 입력하세요");
      adminLoginForm.admin_id.focus();
      return;
   }
   
   if(adminLoginForm.admin_passwd.value === ''){
         alert("관리자 id를 입력하세요");
         adminLoginForm.admin_passwd.focus();
         return;
      }
      
      adminLoginForm.submit();
}

function funcAdminHome(){
   location.href="../guest/guest_index.jsp";
}

function memberUpdate(id){	// 회원 정보 수정용 = 관리자가
	document.updateFrm.id.value = id;	// form 태그 hidden input에 id 값을 설정
	
	document.updateFrm.submit();
}

function memberUpdateAdmin() {	// 폼태그안에 btnUpdateOkAdmin 불러옴
	// alert("aa")
	 document.updateFormAdmin.submit();
}

function memberUpdateCancelAdmin() {  // 폼태그안에 btnUpdateCancelAdmin 불러옴
	// alert("bb")
	location.href = "membermanager.jsp"; // 목록으로 되돌아가기
}

function productDetail(no) {
  document.detailFrm.no.value = no;
  document.detailFrm.submit();
}

function productUpdate(no){
	document.updateFrm.no.value = no;
	document.updateFrm.submit();
}

function productDelete(no){
	if(confirm("정말 삭제하시겟습니까?")){
	document.delFrm.no.value = no;
	document.delFrm.submit();		
	}
}
// 고객상품
function porductDetailGuest(no){
	document.detailFrm.no.value = no;
	document.detailFrm.submit();
}

// 관리자가 주문 처리
function orderDetail(no){
	document.detailFrm.no.value = no;
	document.detailFrm.submit();
}

function orderUpdate(form){
	document.detailFrm.flag.value = "update";
	form.submit();
}

function orderDelete(form){
	document.detailFrm.flag.value = "delete";
	form.submit();
}


