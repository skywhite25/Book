<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
<body>
<div class="container">
<h1>목록</h1>
<table class="table">
	<thead>
	<tr>
		<th>제목</th>
		<th>카테고리</th>
		<th>가격</th>
	</tr>
</thead>
<tbody>
<c:forEach var="row" items="${data }">
	<tr>
	<td>  
		<a href="/detail?bookId=${row.book_id}">${row.title}</a>  
	</td>  
	<td>${row.category}</td>  
	<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price }" />원</td>
	</tr>	
</c:forEach>
</tbody>
</table>
</div>
<p>  
<form>  
<input type="text" placeholder="검색" name="keyword" value="${keyword}" />  
<input type="submit" value="검색" />  
</form>  
	<p>
		<a href="/create" class="btn btn-class">생성</a>
	</p>
</body>
</html>