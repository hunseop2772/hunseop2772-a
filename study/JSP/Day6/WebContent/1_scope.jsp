<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	pageContext.setAttribute("text","pageContext 영역의 변수");
    	request.setAttribute("text","request 영역의 변수");
    	session.setAttribute("text","session영역의 변수");
    	application.setAttribute("text","application영역의 변수");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
</head>
<body>
	<h2>scope</h2>
	<p><%=pageContext.getAttribute("text") %></p>
	<p><%=request.getAttribute("text") %></p>
	<p><%=session.getAttribute("text") %></p>
	<p><%=application.getAttribute("text") %></p>
	<hr>
	<p>default : ${text}</p> <!--pagecontext가 기본 형  -->
	<p>page: ${pageScope.text}</p> 
	<p>request: ${requestScope.text}</p> 
	<p>session: ${sessionScope.text}</p> 
	<p>application: ${applicationScope.text}</p> 
	
	</body>
</html>