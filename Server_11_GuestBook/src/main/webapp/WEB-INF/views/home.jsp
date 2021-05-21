<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-21-002"
	rel="stylesheet" />

<style>
body {
	background-color: black;
}
table#gblist tr:hover {
	cursor: pointer;
	background-color: tomato;
}
</style>

<script>
	document
			.addEventListener(
					"DOMContentLoaded",
					function() {
						document
								.querySelector("table#gblist")
								.addEventListener(
										"click",
										function(ev) {

											// 가장 안쪽 tag(TD)의 이름을 가져와라
											let tag_name = ev.target.tagName;
											if (tag_name = "TD") {
												let gb_seq = ev.target
														.closest("TR").dataset.seq
												document.location.href = "${rootPath}/guest/view?gb_seq="
														+ gb_seq
											}
										}) // tabled에 click
										
										// 방명록 쓰기 button click 시작
										document.querySelector("button.btn_write")
										.addEventListener("click",function(ev){
											//alert("방명록 쓰기")
											document.location.href = "${rootPath}/guest/insert";
										})
										
										// 방명록 쓰기 button click END
										
										
					}) // 전체
</script>

<style>
section#main{
	width : 80%;
	margin: 10px auto;
	border : 2px solid red;
	padding: 5px;
	align-content: center;
	
	
	background-color : black;
	/* opacity :  rgba를 사용하는 대신 바탕색의 투명도를 지적하는 명령 */
}
/* 
form tag block tag type 이기 때문에 button tag와 한 라인에 배치하기 위하여 
display type을 inline-block으로 변환하고
width를 제한하여 설정하였다.*/
section#main form {
	display: inline-block;
	width:30%;
	margin-left:20px;
}

section#main input {
	background-color: black;
	padding: 3px;
	border: 1px solid red;
	margin: 10px auto;
	width:90%;
	color:red;
}

section#main button {
	background-color:  black;
	outline: 0;
	border:1px solid red;
	border-radius: 5px;
	color : red;
	padding: 5px;
	width:100px;
	
	
}

section#main button.btn_write:hover{
	box-shadow: 2px 2px 2px red;
	cursor:pointer;
	background-color: tomato;
}
	

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<section id="main">
		<form>
			<input name="text" />
		</form>
		<button class="btn_write">방명록 쓰기</button>
	</section>
	<table id="gblist">
		<tr>
			<th>작성일</th>
			<th>작성시각</th>
			<th>작성자(email)</th>
			<th>내용</th>
		</tr>
		<c:forEach items="${GBLIST}" var="GB">
			<tr data-seq="${GB.gb_seq}">
				<td>${GB.gb_date}</td>
				<td>${GB.gb_time}</td>
				<td>${GB.gb_writer}</td>
				<td>${GB.gb_content}</td>
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>