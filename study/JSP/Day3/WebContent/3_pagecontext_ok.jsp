<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext 객체</title>
<style>
	body{ background-color : deepskyblue;}
</style>
</head>
<body>
	<h2>pageContext 객체</h2>
	<p> forward() 메소드로 제어권을 받은 페이지입니다.</p>
	<p>세션으로 전달받은 아이디 : <%=session.getAttribute("userid") %></p>
</body>
</html>