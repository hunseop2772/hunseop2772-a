<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.net.URLEncoder" %>
    <%
    	Cookie cookie1 = new Cookie("userid", "apple");
    	Cookie cookie2 = new Cookie("name",  "김사과");
    	
    	cookie1.setMaxAge(180);
    	cookie2.setMaxAge(180); 
    	/* 시간이 지나면 쿠키 삭제(3분) */
    	
    	response.addCookie(cookie1);
    	response.addCookie(cookie2);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키</title>
</head>
<body>
	<h2>쿠키</h2>
	<p>쿠키가 정상적으로 설정되었습니다.</p>
</body>
</html>