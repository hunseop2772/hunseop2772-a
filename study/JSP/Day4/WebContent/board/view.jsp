<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%@ include file="../include/sessioncheck.jsp"%>

<%
	String b_idx = request.getParameter("b_idx");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String b_userid ="";
	String b_name ="";
	String b_title ="";
	String b_regdate ="";
	String b_content ="";
	int b_hit =0;
	int b_like =0;
	
	
	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			String sql = "select * from  tb_board where b_idx=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				 b_userid = rs.getString("b_userid");
				 b_name = rs.getString("b_name");
				 b_title = rs.getString("b_title");
				 b_content = rs.getString("b_content");
				 b_regdate = rs.getString("b_regdate");
				 b_hit = rs.getInt("b_hit");
				 b_like = rs.getInt("b_like");
				}
			
			
			  sql = "update tb_board set b_hit = b_hit +1 where b_idx =?";
			  pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b_idx);
				pstmt.execute();
			
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>

<script>
function like(){
	const xhr = new XMLHttpRequest();
    xhr.open('get', '?b_like=b_like+1',true);
    xhr.send();
    
    xhr.onreadystatechange = function(){
    	 if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
           document.getElementById('text').innerHTML = xhr.responseText
     }
 }
}
</script>

<style>
table {
	width: 800px;
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	padding: 10px;
}
</style>

</head>
<body>
	<h2>글보기</h2>
	<table>
	
		<tr>
		<th>제목</th><td><%=b_title %></td>
		</tr>
		<tr>
		<th>날짜</th><td><%=b_regdate %></td>
		</tr>
		<tr>
		<th>작성자</th><td><%=b_name %>(<%=b_userid %>)</td>
		</tr>
		<tr>
		<th>조회수</th><td><%=b_hit %></td>
		</tr>
		<tr>
		<th>좋아요</th><td><%=b_like %> </td>
		</tr>
		<tr>
		<th>내용</th><td><%=b_content %></td>
		</tr>
	

		
		<tr>
		<td colspan ="2">
		<input type = "button" value="수정">
		<input type = "button" value="삭제">
		<input type = "button" value="리스트" onclick ="location.href='list.jsp'">
		<input type = "button" value="좋아요 " onclick ="like()"  >
		
		</td>
		</tr>
	</table>
	<p id ="text"></p>
</body>
</html>