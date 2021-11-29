<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원정보수정</title>
<script src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<form action="updatingEmployee.do" method="post">
 <table>
	<tr>
		<td>직원번호</td>
		<td><input type="text" name="num" id="num" value="${employeeData.num}"></td>
	</tr>
	<tr>
		<td>직급</td>
		<td><input type="text" name="grade" id="grade" value="${employeeData.grade}"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="ename" id="ename" value="${employeeData.ename}"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="tel" name="phone" id="phone" onkeyup="checkPhone()" value="${employeeData.phone}"></td>
		<td><span class="resultText" id="resultPhone"></span></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="email" name="email" id="email" onkeyup="checkEmail()" value="${employeeData.email}"></td>
		<td><span class="resultText" id="resultEmail"></span></td>
	</tr>
	<tr>
		<td colspan="3"> <input type="submit" onclick="check()" value="수정하기"></td>
		
	</tr>		
	</table>
</form>

</body>
	<!-- js추가 -->
	<script src="js/checking.js"></script>
</html>