<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식</title>
</head>
<body>
	<h2>전송방식(post)</h2> 
	
<!-- 	포스트 방식은 내가 보낸 내용을 url에 보내지 않는다. 사람눈에 보이지 않다
		get 방식보다 전송속도는 느리다.  -->

	<form method="post" action =" 3_post_or.jsp">
		<p>아이디 : <input type = "text" name = "userid"></p>
		<p>비밀번호 : <input type = "password" name = "userpw"></p>
		<p><input type = "submit" value="로그인"></p>
	</form>
	<p><a href ="3_post_or.jsp?userid=banana&userpw=2222">바나나 전송</a></p>
</body>
</html>