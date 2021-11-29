<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원추가</title>
<script src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<form action="insertEmployee.do" method="post">
	<table>
	<tr>
		<td>직급</td>
		<td><input type="text" name="grade" id="grade"></td>
		<td></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="ename" id="ename"></td>
		<td></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="tel" name="phone" id="phone" onkeyup="checkPhone()"></td>
		<td><span class="resultText" id="resultPhone"></span></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="email" name="email" id="email" onkeyup="checkEmail()"></td>
		<td><span class="resultText" id="resultEmail"></span></td>
	</tr>
	<tr>
		<td colspan="2"> <input type="submit"  onclick="check()" value="추가하기"></td>
	</tr>		
	</table>
</form>
</body>
<!-- js추가 -->
<script src="js/checking.js"></script>
</html>