<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check() {
	if (frm.name.value == "") {
		alert("이름을 입력하세요");
		frm.name.focus();
	} else if (frm.pass.value == "") {
		alert("비밀번호를 입력하세요");
		frm.pass.focus();
	} else if (frm.mail.value == "") {
		alert("이메일을 입력하세요");
		frm.mail.focus();
	} else if (frm.title.value == "") {
		alert("제목을 입력하세요");
		frm.title.focus();
	} else if (frm.cont.value == "") {
		alert("내용을 입력하세요");
		frm.cont.focus();
	} else
		frm.submit();
}
</script>
</head>
<body>

</body>
</html>