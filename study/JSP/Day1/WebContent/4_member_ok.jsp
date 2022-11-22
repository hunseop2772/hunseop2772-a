<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
//     	사용자가 서버쪽으로 전달할 경우 인코딩을 설정하겠다. 
    	request.setCharacterEncoding("UTF-8");
    	String userid = request.getParameter("userid"); 
    	String userpw = request.getParameter("userpw");
    	String userpw_re = request.getParameter("userpw_re");
    	String name = request.getParameter("name");
    	String hp = request.getParameter("hp");
    	String email = request.getParameter("email");
    	String gender = request.getParameter("gender");
    	
    	/* getParameterValues() 사용하여 배열로 이용하여 여러 값을 저장가능!!
    		이 후 for문을 활용하여 선택한 배열들을 출력하는 방법을 사용하였다.*/
    	
    	String hobby[] = request.getParameterValues("hobby");
    	String zipcode = request.getParameter("zipcode");
    	String sample6_address = request.getParameter("sample6_address");
    	String sample6_detailAddress = request.getParameter("sample6_detailAddress");
    	String sample6_extraAddress = request.getParameter("sample6_extraAddress");
//     	입력한 값을 변수에 저장하여 폼태그에 전달
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	h2, p{
	text-align:center;
	margin:20px;
	}
	body{background-color : deepskyblue}
</style>
</head>
<body>
	<h2>전송방식</h2>
	<p>아이디 : <%=userid %></p>
	<p>비밀번호 : <%=userpw %></p>
	<p>비밀번호 확인 : <%=userpw_re %></p>
	<p>이름 : <%=name %></p>
	<p>휴대폰 번호 : <%=hp %></p>
	<p>이메일 : <%=email %></p>
	<p>성별 : <%=gender %></p>
	<p>취미 :   <% for(String s: hobby) out.print(s + " !  "); %></p> 
	<p>우편번호 : <%=zipcode %></p>
	<p>주소 : <%=sample6_address %></p>
	<p>상세주소 : <%=sample6_detailAddress %></p>
	<p>참고사항 : <%=sample6_extraAddress %></p>
	
</body>
</html>