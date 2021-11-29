function checkEmail(){
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
	var email = document.getElementById("email").value;
	var resultEmail = document.getElementById("resultEmail").value;
	if (email.match(regExp) == null) {
		$("#resultEmail").text("올바른 이메일 형식이 아닙니다.");
		return false;
	}
	$("#resultEmail").text("");
	return true;
}

function checkPhone(){
	var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/; 
	var phone = document.getElementById("phone").value; 
	if (phone.match(regExp) == null) {
		$("#resultPhone").text("휴대폰 번호는 '-'을 포함하여 입력해주세요.");
		return false;
	}
	$("#resultPhone").text("");
	return true;
}

//입력값 유효성 검사
function checkValidate() {

	// 이메일 유효성 검사
	var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if($('#email').val().match(regEmail) == null) {
		alert('올바른 이메일 형식이 아닙니다.').history.go(-1);
		$('#email').focus();
		return false;
	}
		// 휴대폰 번호 유효성 
	var regPhone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	if($('#phone').val().match(regPhone) == null) {
		alert('휴대폰 번호는 \'-\'을 포함하여 입력해주세요.')
		$('#phone').focus();
		return false;
	}

	return true;
}

function check() {
	if(!checkValidate()) {
		return;
	}
	$.ajax({
		type: "POST",
		url: "insertEmployee.do",
		data: {
			email: $("#email").val(),
			phone: $("#phone").val()
		},
		success: function(res) { 
			if (res == true) {
				alert("성공적으로 등록되었습니다.");
				location.href="main.do";
			} else {
				alert("등록에 실패하였습니다. 확인 후 다시 시도해주세요.");
			}
		},
		error: function(xhr) {
			console.log(xhr.status + " : " + xhr.errorText);
			
		}
	});
}
