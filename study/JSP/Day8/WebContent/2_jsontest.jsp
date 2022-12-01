<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 테스트</title>

<style>
table{width:600px;border:1px solid deepskyblue;}
</style>

<script>
	fetch('http://localhost:8094/Day8/MemberView?m_idx=1').then(function(response){
		response.json().then(function(join)){
			console.log(json);
			for(let key in json){
				document.querySelector('#detail').innerHTML += 
					"<tr><td>" + json[key] +"</td></tr>";
					console.log(json[key]);
			}
		});
	});

</script>

</head>
<body>
	<h2>json 테스트</h2>
	<table id="detail">
	
	
	</table>
</body>
</html>	