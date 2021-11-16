<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>상세 화면</title>
</head>
<body>
	<h1>상세 화면</h1>
	<p>제목 : ${ data.title }</p>
	<p>제목 : ${ data.category }</p>
	<p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price }" /></p>
<%-- 	<p>입력일 : <fmt:parseDate value="${data.insert_date }" var="insert_date1" pattern="yyyy-MM-dd'T'HH:mm:ss" /> --%>
<%-- 		<p>입력일 : <fmt:formatDate value="${data.insert_date }" type="both" dateStyle="short" pattern="yyyy-MM-dd" /></p> --%>
<%-- 		<p>입력일 : <fmt:formatDate value="${data.insert_date }" type="both" dateStyle="short" pattern="yyyy-MM-dd" /></p> --%>
<%-- 			<fmt:formatDate value="${date }" var="data.insert_date" pattern="YYYY.MM.dd" /></p> --%>
<%-- 	<p>입력일 : <fmt:parseDate value="${data.insert_date }" pattern="yyyy-MM-dd HH:mm:ss" var = "date"/>${date }</p> --%>
<%-- 	<p>입력일 : <fmt:parseDate value="${cleanedDateTime }" pattern="yyyy.MM.dd'T'HH:mm:ss " var="parsedDateTime" type="both" /> --%>
<%-- 		<fmt:formatDate value="yyyy.MM.dd HH:mm:ss" value="${parseDateTime }"/></p> --%>
<%-- 		<fmt:setLocale value="en_US" scope="session"/> --%>
<%-- 	<p><fmt:parsedate value="${data.insert_date}" var="dateFmt" pattern="E, dd MMM yyyy HH:mm:ss Z"/> --%>
<%-- 		<fmt:formatdate value="${dateFmt}" pattern="yyyy-MM-dd HH:mm:ss"/></p> --%>

	<p>입력 날짜 : ${data.insert_date }</p>
	<p>
		<a href="/update?bookId=${bookId }">수정</a>
	</p>
	<form method="post" action="/delete">
		<input type="hidden" name="bookId" value="${bookId }">
		<input type="submit" value="삭제" />
	</form>
	<p>
		<a href="/list">목록</a>
	</p>
</body>
</html>