<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
	<script>
		function sendRequest(){
			const xhr = new XMLHttpRequest();
			xhr.open('get', '4_ajax_ok.jsp?userid=apple&userpw=1234',true);
			xhr.send();
			
			/* XMLHttpRequest.DONE -> readyState : 4  */
			xhr.onreadystatechange = function(){
				if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
					document.getElementById('text').innerHTML = xhr.responseText
					
				}
			}
			
		}
	</script>
</head>
<body>
	<h2>Ajax</h2>
	<p><button onclick = "sendRequest()">요청 보내기</button></p>
	<hr>
	<p id ="text"></p>
</body>
</html>