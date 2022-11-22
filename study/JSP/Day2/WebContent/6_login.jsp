<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String userid = null;
    if(session.getAttribute("userid") != null){
    	userid = (String)session.getAttribute("userid");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션으로 구현한 로그인</title>
	
</head>
<body>
	<h2>세션으로 구현한 로그인</h2>
	
	<%
		if(userid ==null){
	%>
	
	<form method ="post" action="6_login_ok.jsp">
		<p>아이디 : <input type ="text" name ="userid"></p>	
		<p>비밀번호 : <input type ="password" name ="userpw"></p>	
		<p><button>login</button></p>
	</form>
	
	<%
		}else{
	%>
	
	<h3><%=userid %>님 환영합니다.</h3>
	<p><a
	 href ="6_logout.jsp">로그아웃</a></p>
	<!-- 기존에 같은 값으로 덮어씌우면 쿠키값을 없는것처럼 할 수 있고 아니면 시간을 0 또는 마이너스로 -->
	<%
		}
	%>
	
</body>
</html>