<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Cookie[] cookies = request.getCookies(); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
</head>
<body>
	<h2>쿠키 읽기</h2>
	<%
		for(Cookie cookie : cookies){
			out.println(cookie.getName() + ":" + cookie.getValue()+ "<br>");
		}
	%>
</body>
</html>