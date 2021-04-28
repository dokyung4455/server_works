<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    int num1 = 10;
    int num2 = 20;
    int sum = num1 + num2;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>JSP(Java Server Page)</h1>
<h3><%= num1%> + <%= num2 %> = <%= sum %></h3>
<p>html 파일에 java 코드를 덫붙여서 java 코딩으로 다양한 기능을 수행할 수 있도록 고안된 기술</p>
<p>1999년에 탄생된 기술</p>
<p>PHP, ASP 등과 같은 기술들이 사용될때 java개발자들을 위해 탄생된 기술p</p>
<p>PHP : c언어와 비슷한 문법으로 된 기술</p>
<p>ASP : Basic, C# 등의 언어를 사용하는 MS에서 만든 기술</p>

<h3>정적 Web Page</h3>
<p>일반적으로 이미지, text 등으로 디자인된 HTML 파일을 사용하여 작성된 Web 화면</p>
<p>*.html, *.htm 형식으로 작성된 파일을 Response 하는 기술</p>

<h3>동적(Dynamic, Interactive) Web Page</h3>
<p>Client(Web Browser)에서 요청하는  Request에 따라 다양한 정보를 보여주는 동적인 Response 하는 기술</p>


</body>
</html>