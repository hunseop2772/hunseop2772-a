<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 테스트</title>
</head>
<body>
	<h2>Servlet 테스트</h2>
	<form method ="post"  action="Login">
	<!-- action 의 Login은 @WebServlet("/Login")과 동일해야 한다 -->
	아이디: <input type ="text" name ="userid">
	<button>로그인</button>
	</form>
	
</body>
</html>