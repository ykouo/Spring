<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css_me/total.css" />

</head>
<body>
<h3><a href="logout.do"><spring:message code="message.main.logout"/></a></h3>
<h1><spring:message code="message.main.boardlist"/></h1>
<hr color="salmon">
	<form action="main.do" method="post">
	<table> <!-- condition keyword -->
		<tr>
			<th>
				<select name ="condition">
					<c:forEach var="op" items="${sm}">
						<option value="${op.value}">${op.key}</option>			
					</c:forEach>
				</select>
			</th>
			<td><input type="text" name="keyword"></td>
			<td><input type="submit" value="<spring:message code="message.main.search"/>"></td>
		</tr>
	</table>
	</form>

<table>
	<tr>
		<td><spring:message code="message.main.bnum"/></td>
		<td><spring:message code="message.main.title"/></td>
		<td><spring:message code="message.main.writer"/></td>
		<td><spring:message code="message.main.date"/></td>
	</tr>
	
	<c:forEach var="v" items="${blist}">
		<tr>
			<td><a href="showpost.do?bid=${v.bid}">${v.bid}</a></td>
			<td>${v.title}</td>
			<td>${v.mid}</td>
			<td>${v.wdate}</td>
		</tr>
	</c:forEach>
</table>
	<!-- pagination -->
		<div id="paging" >
			<ul class="pagenation">
					<c:if test="${paging.pageNum==paging.firstPageNum}">
						<li>
						<a href="main.do?page=${paging.prevPageNum}"><spring:message code="messgae.main.prev"/></a>
						</li>
					</c:if>
					<c:if test="${paging.pageNum!=paging.firstPageNum}">
						<li><a
							href="main.do?page=${paging.prevPageNum}"><spring:message code="messgae.main.prev"/></a></li>
					</c:if>

					<c:forEach var="i" begin="${paging.startPageNum}"
						end="${paging.endPageNum}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNum}">
								<li><a class="page">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="main.do?page=${i}"class="page">${i}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${paging.pageNum==paging.finalPageNum}">
						<li>
							<a href="main.do?page=${paging.nextPageNum}"class="button disabled"><spring:message code="messgae.main.next"/></a>
						</li>
					</c:if>
					<c:if test="${paging.pageNum!=paging.finalPageNum}">
						<li>
							<a href="main.do?page=${paging.nextPageNum}"class="button"><spring:message code="messgae.main.next"/></a>
						</li>
					</c:if>
			</ul>
		</div>

<hr color="salmon">
<a href="insertBoard.jsp"><spring:message code="message.main.addboard"/></a>

</body>
</html>