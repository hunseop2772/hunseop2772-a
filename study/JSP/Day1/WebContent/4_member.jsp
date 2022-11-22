<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
body{background-color : deeppink}
	h2, p{
	text-align:center;
	margin:20px;
	}
</style>
</head>
<body>
<h2>전송방식 과제(post)</h2> 
<!-- 	포스트 방식은 내가 보낸 내용을 url에 보내지 않는다. 사람눈에 보이지 않다 -->
	<form method="post" action =" 4_member_ok.jsp">
		     <p>아이디 : <input type="text" name = "userid" ></p>
        <p>비밀번호 : <input type="password" name = "userpw" > </p>
        <p>비밀번호 확인 : <input type="password" name = "userpw_re" > </p>
        <p>이름 : <input type="text" name="name" ></p>
        <p>휴대폰 번호 : <input type="text" name="hp" ></p>
        <p>이메일 : <input type="text" name="email""></p>
        <p>성별 :<label> 남자 <input type="radio" name="gender" value="남자" checked></label> <label> 여자 <input type="radio" name="gender" value="여자"></label></p>
        <p>취미 :  <label>등산<input type="checkbox" name="hobby" value="등산"></label>
         <label>게임<input type="checkbox" name="hobby" value="게임"></label>
         <label>영화감상<input type="checkbox" name="hobby" value="영화감상"></label>
        <label>드라이브<input type="checkbox" name="hobby" value="드라이브"></label>
       <label>운동<input type="checkbox" name="hobby" value="운동"></label></p>
       
       <p>우편번호: <input type="text" name="zipcode" maxlength="5" id="sample6_postcode" ><button type="button" onclick="sample6_execDaumPostcode()">검색</button></p>
       <p>주소 <input type="text" name="sample6_address"></p>
       <p>상세주소 <input type="text" name="sample6_detailAddress"></p>
       <p>참고사항 <input type="text" name="sample6_extraAddress"></p>
		<p><input type = "submit" value="가입완료"></p>
	</form>
</body>
</html>