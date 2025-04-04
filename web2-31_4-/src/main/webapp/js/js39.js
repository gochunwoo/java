$(document).ready(function(){
	$("#id_err").hide();
	$("#age_err1").hide();
	$("#age_err2").hide();
	$("#pwd_err1").hide();
	$("#pwd_err2").hide();
	
	$("#btnSend").click(function(){
		// 입력자로 오류 검사 후 자료를 서버버로 전송
		
		// id검사
		let id = $("#userid").val(); // document.querySelector("#userid").value
		if(id.length < 2 || isNaN(id) === false){
			$("#id_err").show();
			return false;
		}else{
			$("#id_err").hide();
		}
		
		// age 검사 1
		let age = $("#age").val(); // document.querySelector("#userid").value
				if(age.length < 1){
					$("#age_err1").show();
					return false;
				}else{
					$("#age_err1").hide();
				}
				
		//age 검사 2 : 양의 숫자만 허용
		/*
		for(let i=0; i < age.length; i++){
			// 한 글자씩 출력후 Ascii 코드 값 얻기
			let data = age.charAt(i).charCodeAt(0);
			alert(data);
			if(data < 48 || data > 57){
				$("#age_err2").show();
				return false;
			}else {
				$("#age_err2").hide();
				
			}
		}*/
		
		
		
		// 사용자 정의 함수 호출
		if(!isPositiveIntegeMyFunc(age) || age < 15 || age > 90) {
			$("#age_err2").show();
			return false;
		}else{
			$("#age_err2").hide();
		}
		// 또는 정규표현식 등의 다양한 방법이 있다...
		
		// 비밀번호 검사 : 두개의 비번이 일치해야함
		let pwd1 = $("#pwd1").val();   // 잘못된 선택자, 아이디 선택자는 #을 사용해야 함
		if(pwd1.length < 1) {
		    //$("pwd1_err1").show();
		    $("#pwd1").next().show();  // next()는 메서드 호출 뒤에 괄호()가 필요
		    return false;
		}else{
		    // $("pwd1_err1").hide();
		    $("#pwd1").next().hide();  // next() 메서드 호출 뒤 괄호()가 필요
		}

		
		let pwd2 = $("#pwd2").val();
		if(pwd1 !== pwd2){
			$("#pwd_err2").show();
		}else{
			$("#pwd_err2").hide();
		}
		
		// 오류 검사 통ㅎ과 후 자료를 ㅅ버ㅓ로 전송
		$("#signFrm").attr("action", "/js39.jsp").attr("method", "get").submit();

		
	
	})
});
// 사용자 정이ㅡ 함수 작성
function isPositiveIntegeMyFunc(para){
	let num = Number(para);
	return Number.isInteger(num);
}































