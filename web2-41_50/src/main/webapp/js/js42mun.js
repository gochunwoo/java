$(document).ready(function() {
	$("#btnSearch").click(function() {
		$("#show").empty();

		let bname = $("#name").val();

		$.ajax({
			type: "get",
			url: "js42mun.jsp",
			data: { "name": bname },
			dataType: "json",
			success: function(datas) {
				// alert(datas.jikwons.length);  // 데이터를 콘솔에서 확인하기 위한 alert
				let count = 0;
				let str = "<table border='1'>";
				str += "<tr><th>사번</th><th>직원명</th><th>직급</th><th>연봉</th></tr>";  // 테이블의 헤더 추가

				// 데이터가 jikwons 배열에 들어있다고 가정하고 출력
				$.each(datas.jikwons, function(idx, data) {
					str += "<tr>";
					str += "<td>" + data["jikwonno"] + "</td>";
					str += "<td>" + data["jikwonname"] + "</td>";
					str += "<td>" + data["jikwonjik"] + "</td>";
					str += "<td>" + data["jikwonpay"] + "</td>";
					str += "</tr>";
					count++;  // 직원수
				});

				str += "</table>";  // 테이블 닫기
				$("#show").append(str);  // 테이블을 #show에 출력
				
			},
			error: function() {
				$("#show").append("직원 읽기 에러");
			}
		});
	});
});