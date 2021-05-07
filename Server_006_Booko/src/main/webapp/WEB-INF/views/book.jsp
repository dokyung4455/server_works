<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri=""http://java.sun.com/jstl/core" prefic="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>도서 검색결과</h1>
<c:if test="${empty BOOKS}">검생결과가 없음!!</c:if>
<c:forEach items="${BOOKS}" var="BOOK">
<p>${BOOK.bk_isbn },
$
</c:forEach>

</body>
</html>