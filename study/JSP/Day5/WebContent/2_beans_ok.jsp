<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean class="com.koreait.Member" id="member" scope = "request"/>
    
    
<%--     <jsp:setProperty property="userid" name="member"/>
    <jsp:setProperty property="userpw" name="member"/>
    <jsp:setProperty property="name" name="member"/>
    <jsp:setProperty property="email" name="member"/>
    <jsp:setProperty property="hp" name="member"/> --%>
    
 <jsp:setProperty property="*" name="member"/> 
 <jsp:setProperty property="hp" param="tel" name="member"/> 
 <!--변수가 한가지 다를경우 param을 사용하여 다른 부분을 변경할 수 있다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Beans</title>
</head>
<body>
	<p>member2 아이디: <jsp:getProperty property="userid" name="member"/></p>
	<p>member2 비밀번호: <jsp:getProperty property="userpw" name="member"/></p>
	<p>member2 이름: <jsp:getProperty property="name" name="member"/></p>
	<p>member2 이메일: <jsp:getProperty property="email" name="member"/></p>
	<p>member2 휴대폰번호: <jsp:getProperty property="hp" name="member"/></p>
</body>
</html>