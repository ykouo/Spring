<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css_me/total.css" />
</head>
<body>
<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td><spring:message code="message.login.id"/></td>
			<td><input type="text" name="mid" value="${guest.mid}" required="required"></td>
		</tr>
		<tr>
			<td><spring:message code="message.login.pw"/></td>
			<td><input type="password" name="mpw" value="${guest.mpw}" required="required"></td>
		</tr>
		<tr class="loginBtn" >
			<td colspan="2"><input type="submit" value="<spring:message code="messgae.login.loginbtn"/>"></td>
		</tr>
	</table>
	<a href="insertMember.jsp" ><spring:message code="message.login.gojoin"/></a>
</form>
</body>
</html>