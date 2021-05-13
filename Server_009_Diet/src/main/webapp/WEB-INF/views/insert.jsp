<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		box-sizing: border-box;
	
	}
	h1, form {
		width: 80%;
		margin: 10px auto;
	}
	h1 {
		background-color: rgba(200, 230, 230, 0.8);
		color:white;
		padding: 1.2rem;
		text-align: center;
	}
	form {
		border:1px solid rgba(200, 230, 230, 0.9);
		padding: 10px;
		border-radius: 10px;
}
label {
	display:inline-block;
	width: 20%;
	text-align: right;
	padding: 8px;
	maggin: 5px;
}
input {
	width: 50%;
	padding: 8px;
	maggin: 5px;
}
button {
font-size:15pt;
	background-color: rgba(200, 230, 230, 0.8);
	color:white;
	padding:4px;
	width:5%;
	text-align: center;
	outline: 0;
	border: 0;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	/* x-offset y-offset blue spread color */
	box-shadow: 2px 2px 2px rgba(0,0,0, 0.9);
}
</style>
</head>
<body>
	<h1>식품 섭취 내역 입력</h1>
	<form method="POST" >
	<p><label>식품코드 : </label><input name ="mf_code" value ="${FOOD.fd_code}"/>
	<p><label>식품이름 : </label><input name ="mf_name" value ="${FOOD.fd_name}"/>
	<p><label>섭취일자 : </label><input name ="mf_date" value ="${TODAY}"/>
	<p><label>섭 취 량 : </label><input name ="mf_qty" value ="1"/>	
	<button>등록</button></p>
	</form>
</body>
</html>