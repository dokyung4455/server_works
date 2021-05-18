<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-18-001"
	rel="stylesheet" />
<style type="text/css">

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>

	<table>
		<tr>
			<th>작성일</th>
			<th>작성시각</th>
			<th>작성자(email)</th>
			<th>내용</th>
		</tr>
		<c:forEach items="${GBLIST}" var="GB">
			<tr>
				<td>${GB.gb_date}</td>
				<td>${GB.gb_time}</td>
				<td>
				<a href="${rootPath}/guest/view?gb_seq=${GB.gb_seq}">
				${GB.gb_writer}
				</a>
				</td>
				<td>${GB.gb_content}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
