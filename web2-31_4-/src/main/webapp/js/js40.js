$(document).ready(function() {
	$("#btnXml").click(function() {
		$("#show1").empty();
		$.ajax({
			type: "get",
			url: "js40dbxml.jsp",
			dataType: "xml",
			success: function(datas) {
				// alert($(datas).find("sangpum").length);
				$(datas).find("sangpum").each(function() {
					let obj = $(this); // 순차적으로 현재 선택된 상품(행)
					let str = "<div>"
					str += obj.find("code").text() + " ";
					str += obj.find("sang").text() + " ";
					str += obj.find("su").text() + " ";
					str += obj.find("dan").text() + " ";
					str += "<div>"
					$("#show1").append(str);
				});

			},
			error: function() {
				$("#show1").append("xml 일기 오류");
			}
		});
	});

	$("#btnJson").click(function() {
		$("#show2").empty();
		$.ajax({
			type: "get",
			url: "js40dbjson.jsp",
			dataType: "json",
			success: function(datas) {
				// alert(datas.sangpum.length);
				$.each(datas.sangpum, function(idx, data) {
					let str = "<div>"
					str += data["code"] + " ";
					str += data["sang"] + " ";
					str += data["su"] + " ";
					str += data["dan"] + " ";
					str += "<div>";
					$("#show2").append(str);
				});
			},
			error: function() {
				$("#show1").append("json 일기 오류");
			}
		});
	});
});
