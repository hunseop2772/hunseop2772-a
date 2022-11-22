<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.Date" %>
    
    <%-- ❗        <%@ page ~~~ %> : 페이지 무조건 최상단, 정보를 설정하는 페이지
language : 사용할 프로그래밍 언어, java를 사용 
contentType : 생성할 문서의 컨텐츠 유형, HTML 사용
pageEncoding : 문자 인코딩을 설정 -> UTF-8을 사용한다.
java.util.Date -> Date형식을 가저오는 정보 설정 페이지

  ❗--%>
    
    
    
    <%-- <%~ %>를 사용하여 변수를 선언 
    userid, name, age, height 를 선언함 --%>
    
    
    <%
    	String userid ="apple";
	    String name = "김사과";
	    int age =20;
	    double height = 160.5;
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수</title>
		<style >
			h2, p {text-align:center;}
		</style>
		
		
		<!-- HTML, CSS를 전부 사용이 가능 -->
		
		
</head>
<body>
	 <h2>변수 (현재시간 : <%=new Date() %>)</h2> <!-- DATE 날자를 제목에 넣음  -->
	 <p>아이디 :<%=userid %> </p>
	 <p>이름 :<%=name %> </p>
	 <p>나이:<%=age %> </p>
	 <p>키:<%=height%> </p>
	 
	<%--  <!--  변수 또는 계산식,메소드 등을 호출한다.
        여기에서는 userid, name 등을 변수로 선언하였다. --> --%>
	  
	 <%
	 	out.println("<p>안녕하세요. JSP 테스트 페이지 입니다.</p>");
	 out.println("<p>"+name + "님 환영합니다!</p>");
	 System.out.println("콘솔에 출력합니다.");
	 
	  
	 if(age>19){
		 out.println("<p> 성인입니다. </p>");
	 }else{
		 out.println("<p> 미성년입니다. </p>");
	 }
	 %>
	 
<!-- 	  /*if 문  사용이 가능하며 out.println(<p></p>)
	 를 사용하여 브라우저에 출력이 가능하며 
	 System.out.println을 사용하여 콘솔 창에 출력하게 한다.*/ -->
	 
	 
</body>
</html>