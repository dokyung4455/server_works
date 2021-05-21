<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	form.v1 {
		width: 80%;
		margin: 10px auto;
		
	}
	body {
		background-color: black;
	}
	
	form.v1 fieldset {
		border:2px solid red;
		border-radius: 10px;
		padding:5px;
	}
	
	form.v1 label, form.v1 input, form.v1 textarea {
	color:red;
		margin: 5px;
		padding: 5px;
	}
	
	form.v1 label{
		color:red;
		display: inline-block;
		width: 150px;
		text-align: right;
	}
	form.v1 input, form.v1 textarea {
		display: inline-block;
		width: 300px;
		border: 1px solid red;
		background-color: rgba(250,250,250,0.7);
	}
	form.v1 div.btb{
	text-align: right;
	}
	form.v1 button {
		outline:0;
		border:0;
		width: 100px;
		color:red;
	}
	form.v1 button:nth-child(2){
		border: 1px solid red;
		background-color: black;
		padding:0.5rem;
	}
	form.v1 button:nth-child(3){
	border: 1px solid red;
		background-color: black;
		padding:0.5rem;
	}
	form.v1 button:nth-child(4){
	border: 1px solid red;
		background-color: black;
		padding:0.5rem;
	}
	form.v1 button:hover {
		box-shadow: 2px 2px 2px red; 
		background-color: tomato;
		cursor:pointer;
	}
	form.v1 legend {
		background-color:red;
		border-radius:5px;
		font-size:20px;
		color : black;
		text-align: center;
		padding: 10px,10px auto;
	}
</style>
<script>
// script를 본문 어디에나 두기 위해 document에 Event 설정
// 화면에 모든 요소가 다 그려지면
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("button.btn_save").addEventListener("click",function(ev){
			
			let dom = document;
			let gb_writer = dom.querySelector("input[name='gb_writer']");
			let gb_email = dom.querySelector("input[name='gb_email']");
			let gb_password = dom.querySelector("input[name='gb_password']");
			let gb_content = dom.querySelector("textarea[name='gb_content']");
			/*alert(gb_writer
					+ "\n"
					+ gb_email
					+ "\n"
					+ gb_password
					+ "\n"
					+ gb_content
					+ "\n"
					);*/
			if(gb_writer.value == "") {
				alert("작성자 이름은 반드시 입력해야 합니다.")
				//dom.querySelector("input[name='gb_writer']").focus()
				gb_writer.focus();
				return false;
			}
			if(gb_email.value == "") {
				alert("E-mail은 반드시 입력해야 합니다.")
				gb_email.focus();
				return false;
			}
			if(gb_password.value == "") {
				alert("password를 입력하세요.")
				gb_password.focus();
				return false;
			}
			if(gb_content.value == "") {
				alert("내용을 입력하세요!")
				gb_content.focus();
				return false;
			}
			
			// 서버로 이동시키는
			dom.querySelector("form.v1").submit();
			
		})
		
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<form class="v1" method="POST">
		<fieldset>
		<legend>방명록 쓰기</legend>
		<div>
			<label>작성일자</label>
			<input name="gb_date" type="date" value="${GB.gb_date}">
		</div>
		
		<div>
			<label>작성시각</label>
			<input name="gb_time" type="time" value="${GB.gb_time}">
		</div>
		
		<div>
			<label>작성자</label>
			<input name="gb_writer" type="text" value="${GB.gb_writer}">
		</div>
		
		<div>
			<label>작성자 E-mail</label>
			<input name="gb_email" type="email" value="${GB.gb_email}">
		</div>
		
		<div>
			<label>비밀번호</label>
			<input name="gb_password" type="password">
		</div>
		
		<div>
			<label>내용입력</label>
			<textarea name="gb_content" rows="5">${GB.gb_content}</textarea>
		</div>
		<div class="btn">
			<label></label>
			<button class="btn_save" type="button">저장</button>
			<button type="reset">다시작성</button>
			<button class="btn+home" type="button">처음으로</button>
		</div>
		</fieldset>
	</form>

</body>
</html>