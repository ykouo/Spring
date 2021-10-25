<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오로그인-자바스크립트</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
<a href="javascript:kakaoLogin();"><img src="images/kakao_login_medium_narrow.png"></a>
<a href="javascript:kakaoLogout();">카카오로그아웃</a>

<script type="text/javascript">
Kakao.init('발급받은 javascript key'); // javascript api키를 입력
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() { // 카카오로그인 메서드 
    Kakao.Auth.login({	
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

</body>
</html>