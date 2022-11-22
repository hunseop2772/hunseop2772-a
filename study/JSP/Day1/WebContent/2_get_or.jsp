<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    
    
<%-- ❗        <%@ page ~~~ %> : 페이지 무조건 최상단, 정보를 설정하는 페이지
language : 사용할 프로그래밍 언어, java를 사용 
contentType : 생성할 문서의 컨텐츠 유형, HTML 사용
pageEncoding : 문자 인코딩을 설정 -> UTF-8을 사용한다.❗  --%>
  
  
   <%
//     	사용자가 서버쪽으로 전달할 경우 인코딩을 설정하겠다. 
    	request.setCharacterEncoding("UTF-8");
    	String userid = request.getParameter("userid"); 
    	String userpw = request.getParameter("userpw");
//     	입력한 값을 변수에 저장하여 폼태그에 전달
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식(get)</title>
 <!-- URL에 저장되는 방식 -->
</head>
<body>
	<h2>전송방식</h2>
	
	<p>아이디 : <%=userid %></p>
	<p>비밀번호 : <%=userpw %></p>
</body>
</html>