<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
//     	사용자가 서버쪽으로 전달할 경우 인코딩을 설정하겠다. 
    	request.setCharacterEncoding("UTF-8");
    	String userid = request.getParameter("userid"); 
    	String userpw = request.getParameter("userpw");
//     	입력한 값을 변수에 저장하여 폼태그에 전달
    %>
<!DOCTYPE html>
<html>"WebContent/4_member_ok.jsp"
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전송방식</h2>
	<p>아이디 : <%=userid %></p>
	<p>비밀번호 : <%=userpw %></p>
</body>
</html>