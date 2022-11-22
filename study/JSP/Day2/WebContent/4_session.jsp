<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	session.setAttribute("userid", "apple");
    //  B0974869CBE0B908661BE62D3F74CDFA -> userid(apple)
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	<h2>session</h2>
	<p>session id: <%=session.getId() %></p>
</body>
</html>