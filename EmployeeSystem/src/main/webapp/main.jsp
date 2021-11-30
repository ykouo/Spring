<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원정보리스트 페이지</title>
<script src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1> 직원 LIST page</h1>
<hr>
	<form action="main.do" method="post">
			<table>
				<tr>
					<td>
					<select name="condition">
							<c:forEach var="op" items="${sm}">
								<option value="${op.value}">${op.key}</option>
							</c:forEach>
					</select>
					</td>
					<td><input type="text" name="keyword"></td>
					<td><input type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
	<table border="1" id="csvtable"> 
		<tr>
			<th>직원번호</th>
			<th>직급</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th >삭제</th>
		</tr>
		<c:forEach var = "employee" items="${employeeList}" >
			<tr>
				<td><a href="goUpdateEmployee.do?num=${employee.num}">${employee.num}</a></td>
				<td>${employee.grade}</td>
				<td>${employee.ename}</td>
				<td>${employee.phone}</td>
				<td><a href="goSendEmail.do?num=${employee.num}">${employee.email}</a></td>
				<td ><input type="button" onclick="location.href='deleteEmployee.do?num=${employee.num}'" style="width: 50px;" value="삭제"></td>				
				
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	<button type="button" onclick="location.href='insertEmployee.jsp'">직원추가</button>
	<button id="csvDownloadButton">CSV 다운로드 받기</button>
</body>
	<!-- js추가 -->
	<script src="js/download.js"></script>
</html>