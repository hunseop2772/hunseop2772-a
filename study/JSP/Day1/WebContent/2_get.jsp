<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식(get)</title>
</head>
<body>
	<h2>전송방식(get)</h2>
	
<!-- 	사람눈에 보이고 보안은 취약하지만 속도는 post에 비해 빠르다는 장점을 가지고 있다 -->

	<form method="get" action =" 2_get_or.jsp">
		<p>아이디 : <input type = "text" name = "userid"></p>

	<!-- userid, userpw 등 내가 입력한 내용 즉 벨류값을 알 수 있다 -->
	
		<p>비밀번호 : <input type = "password" name = "userpw"></p>
		<p><input type = "submit" value="로그인"></p>
	</form>
	<p><a href ="2_get_or.jsp?userid=banana&userpw=2222">바나나 전송</a></p>
</body>
</html>