<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String userid = request.getParameter("userid");
    	String userpw = request.getParameter("userpw");
    	
    	if(userid.equals("apple") && userpw.equals("1234")){
    		//login    	
    		Cookie cookie = new Cookie("userid",userid);
    		cookie.setMaxAge(60*10);
    		response.addCookie(cookie);
    %>
    
    <script>
    alert('로그인 되었습니다.')
    location.href = "3_login.jsp";
    //refresh - 데이터가 갱신이됨, 새로운 페이지를 가지고 오며 캐시가 날라간다.
    </script>  
    
    <%		
    	}else{
    		//login X
    %>
    		 
    		  <script>
    		  alert('아이디 또는 비밀번호를 확인하세요.')
			history.back();
    		  // 캐시가 남는다 -> 캐시에 있는 정보를 가지고 앞, 뒤로 이동 한다. 
    		 </script> 
    		 
    <% 		  		
    	}
%>