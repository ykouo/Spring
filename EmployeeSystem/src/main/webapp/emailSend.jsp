<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>"${employeeData.ename}"사원님에게 메일 발송</h1>
	<form action="sendMail.do" method="post" id="">
		<table border="1">
		<tr>
			<td>받는 사람</td>
			<td><input type="email" name="to" id="email" required="required" value="${employeeData.email}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>보내는 사람</td>
			<td><input type="text" name="from" value="anykouo@gmail.com" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" required="required"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" placeholder="메일내용을 작성하세요" cols="30" rows="10" maxlength="500"
					style="resize: none;" required="required"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="SendMail"></td>
		</tr>
			
		</table>
	</form>
</body>
</html>