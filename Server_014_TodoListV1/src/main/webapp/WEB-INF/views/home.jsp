<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY TODO List</title>
<style>
/* style 지정을 위하여 전체 초기화 */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	background: rgb(255, 67, 67);
	background: linear-gradient(90deg, rgba(255, 67, 67, 1) 0%,
		rgba(0, 0, 0, 1) 50%, rgba(255, 64, 64, 1) 100%);
}

h1, form.doit, table.td_list {
	width: 50%;
	margin: 10px auto;
	border-radius: 5px;
}

h1 {
	background-color: grey;
	color: white;
	padding: 1rem;
	text-align: center;
	/* text에 그림자 지정 */
	text-shadow: 1px 1px 1px #000;
}

form.doit {
	border: 1px solid red;
	padding: 10px;
	text-align: center;
}

form.doit input {
	width: 90%;
	/* 
		input box를 클릭하면 
		진한 box가 생기는 것을 방지 
		*/
	outline: 0;
	border: 1px solid #eee;
	border-radius: 5px;
	padding: 15px;
	margin: 10px;
	font-weight: bold;
}

form.doit input:hover {
	background-color: #eee;
}

table.td_list {
	border-collapse: collapse;
	border-spacing: 0px;
	color: white;
}

table.td_list td {
	padding: 5px;
	border: 1px solid white;
	cursor: pointer;
}

/* table의 가장 마지막 tr(ling)에 칼럼들에게만 적용*/
table.tdlist tr:nth-last-child td() {
	
}

table.td_list td.sdate, table.td_list td.date {
	font-size: 13px;
	text-align: center;
	width: 20%;
}

table.td_list td.doit {
	max-width: 80%;
	font-size : 26px;
	text-align: left;
	/*
		width : 무조건 폭을 지정
		max-width : 포함된 text(content)길이에 따라 조절을 하되 최소 크기만 제한
		
		max-width:80%;
		
		최대 width보다 text가 더 많더라도 자동으로 줄바꿈 하지 않기
		*/
	/*
	td의 width 보다 큰 text를 말줄임표로 표현하기
	td 3인데 
	첫번째, 세번째 td를 20% 설정했기 때문에 여기 td는 전체 table width의 60%가 될것이고
	이 상태에서 max-width를 0으로 지정하고 ellipsis 설정을 해주면 된다.
	*/
	max-width:0;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	
}

table.td_list tr:hover {
	background-color: #eee;
	color: black;
}

.text-throth{
	text-decoration: 3px line-through; red wavy;
}

/*
	media query
*/
@media screen and (max-width:400px){
	h1, form.doit, table.td_list{
		width:95%;
		margin: 5px auto;
	}
}
</style>
<script>
	// script가 어디에 위치하든 상관없이 이후의 다른 Event가 정상적으로 설정될 수 있도록 선언
	// 화면에 DOM요소가 모두 완전하게 나타나면 내부의 코드를 실행하라.
	document.addEventListener("DOMContentLoaded",()=>{
		// ()=>{  } : 화살표 함수 : function() {  }
		document.querySelector("table.td_list")
			.addEventListener("dblclick",(ev)=>{
				// table의 TD 항목이 클릭되었을때만 반응하기 위해
				let tagName = ev.target.tagName;				
				if(tagName =="TD") {
					// 방금 더블클릭된 TD를 감싸고 있는 TR의 
					let seq = ev.target.closest("TR").dataset.seq;
					let edate = ev.target.closest("TR").dataset.edate;
					
					let msg = edate ? "TODO 완료를 취소합니다."
							: "TODO 를 완료처리 합니다."
							
					if(confirm(msg)){
						location.href="${rootPath}/sub/expire?seq="+ seq
					}
				}
			})
		
	})
</script>




</head>
<body>
	<h1>TO DO List</h1>

	<%--
		form tag의 action 속성
		form tag의 action 속성은 form에 담긴 데이터를
		submit할때(서버로 전송할때)
		어떤 uri path를 통해서 서버에 보낼것인가를
		지정하는 것
		
		만약 이 action 속성을 지정하지 않으면
		현재 파일(home.jsp)을 보여줄때 사용한
		uri 주소가 자동으로 설정이 된다
		
		${rootPath}/ 처럼 주소를 지정하는 것
		form, a tag등에 URL, URI를 지정할때
		
		주소의 지정방식에 따라 상대주소, 
		절대주소 방법이 있는데
		지정하는 방법에 따라 연결이 잘 안되는 경우가 많다
		
		우리 프로젝트는 모두 절대주소 지정방식으로 통일하고
		항상 주소(URI, URL)과 관련된 모든 항목은
		${rootPath} 시작하는 주소로 사용한다
		rootPath = http://localhost:8080/todo
		 --%>
	<form class="doit" method="POST" action="${rootPath}/sub/insert">
		<input name="td_doit" placeholder="할일을 입력한 후 Enter">
	</form>
	<table class="td_list" style="align: center">
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq}" data-edate="${TD.td_edate}">
				<td class="sdate">${TD.td_sdate}<br />${TD.td_stime}</td>
				<td class="doit">${TD.td_doit}
				<td class="edate">${TD.td_edate}<br />${TD.td_etime}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>