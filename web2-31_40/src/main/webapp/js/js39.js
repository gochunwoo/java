$(document).ready(function(){
    $("#id_err").hide();
    $("#age_err1").hide();
    $("#age_err2").hide();
    $("#pwd_err1").hide();
    $("#pwd_err2").hide();

    $("#btnSend").click(function(){
        // 입력 오류 검사 후 서버로 전송

        // id검사
        let id = $("#userid").val(); // document.querySelector("#userid").value
        let idRegex = /^[a-zA-Z]{2,}$/;
        if (!idRegex.test(id)) {
            $("#id_err").show();
            return false;
        } else {
            $("#id_err").hide();
        }

        // age 검사 1
        let age = $("#age").val(); // document.querySelector("#userid").value
        if(age.length < 1){
            $("#age_err1").show();
            return false;
        } else {
            $("#age_err1").hide();
        }

        // age 검사 2 : 양의 숫자만 허용
        if(!isPositiveIntegeMyFunc(age) || age < 15 || age > 90) {
            $("#age_err2").show();
            return false;
        } else {
            $("#age_err2").hide();
        }

        // 비밀번호 검사 : 두개의 비번이 일치해야 함
        let pwd1 = $("#pwd1").val();   // 잘못된 선택자, 아이디 선택자는 #을 사용해야 함
        if(pwd1.length < 1) {
            $("#pwd1").next().show();  // next()는 메서드 호출 뒤에 괄호()가 필요
            return false;
        } else {
            $("#pwd1").next().hide();  // next() 메서드 호출 뒤 괄호()가 필요
        }

        let pwd2 = $("#pwd2").val();
        if(pwd1 !== pwd2){
            $("#pwd_err2").show();
        } else {
            $("#pwd_err2").hide();
        }

        // 오류 검사 통과 후 자료를 서버로 전송
        $("#signFrm").attr("action", "/js39.jsp").attr("method", "post").submit();
    });
});

// 사용자 정의 함수 작성
function isPositiveIntegeMyFunc(para){
    let num = Number(para);
    return Number.isInteger(num);
}
