<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
   		 String msg = request.getParameter("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>폼 테스트</h2>
	<p>전달된 메시지 : <%=msg %></p>
</body>
</html>