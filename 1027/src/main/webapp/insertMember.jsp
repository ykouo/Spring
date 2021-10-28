<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/total.css" />
</head>
<body>
<form action="joinMember.do">
	<table border="1">
		<tr>
			<td><spring:message code="message.join.id"/></td>
			<td><input type="text" name="mid" required="required"></td>
		</tr>
		<tr>
			<td><spring:message code="message.join.pw"/></td>
			<td><input type="password" name="mpw" required="required"></td>
		</tr>
		<tr>
			<td><spring:message code="message.join.nickname"/></td>
			<td><input type="text" name="mname" required="required"></td>
		</tr>
		<tr>
			<td><spring:message code="messgae.join.call"/></td>
			<td><input type="tel" name="call" required="required"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="<spring:message code="message.join.joinIn"/>"></td>
		</tr>
	</table>
	<a href="index.jsp"><spring:message code="messgae.join.gomain"/></a>
</form>
</body>
</html>