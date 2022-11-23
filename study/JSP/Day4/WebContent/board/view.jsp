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

	String userid = (String) session.getAttribute("userid");
	String name = (String) session.getAttribute("name");
	String b_userid = "";
	String b_name = "";
	String b_title = "";
	String b_regdate = "";
	String b_content = "";
	String re_boardidx = "";
	
	int b_hit = 0;
	int b_like = 0;

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {

			String sql = "update tb_board set b_hit = b_hit +1 where b_idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			pstmt.executeUpdate();

			sql = "select * from  tb_board where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			
			

			if (rs.next()) {
				b_userid = rs.getString("b_userid");
				b_name = rs.getString("b_name");
				b_title = rs.getString("b_title");
				b_content = rs.getString("b_content");
				b_regdate = rs.getString("b_regdate");
				b_hit = rs.getInt("b_hit");
				b_like = rs.getInt("b_like");
			}

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
    xhr.open('get', 'view_ajax.jsp?b_idx=<%=b_idx%>', true);
		xhr.send();

		xhr.onreadystatechange = function() {
			if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
				document.getElementById('text').innerHTML = xhr.responseText
			
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
<script>
	function del(idx) {
		/* alert(idx); */
		const yn = confirm('글을 삭제하시겠습니까?');
		if (yn)
			location.href = 'delete_ok.jsp?b_idx=' + idx;
	}
	
	function replyDel(re_idx,b_idx){
		const yn = confirm('해당 댓글을 삭제하시겠습니까?');
		if (yn)
			location.href = 'reply_del_ok.jsp?re_idx=' + re_idx + "&b_idx=" +b_idx;
	}
</script>
</head>
<body>
	<h2>글보기</h2>
	<table>

		<tr>
			<th>제목</th>
			<td><%=b_title%></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><%=b_regdate%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=b_name%>(<%=b_userid%>)</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=b_hit%></td>
		</tr>
		<tr>
			<th>좋아요</th>
			<td id="text"><%=b_like%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=b_content%></td>
		</tr>

		<tr>
			<td colspan="2">
				<%
					if (b_userid.equals(userid)) {
				%> <input type="button" value="수정"
				onclick="location.href='edit.jsp?b_idx=<%=b_idx%>'"> <%-- <input type = "button" value="삭제" onclick = "location.href='delete_ok.jsp?b_idx=<%=b_idx%>'"> --%>
				<input type="button" value="삭제" onclick="del('<%=b_idx%>')">
				<%
					}
				%> <input type="button" value="리스트"
				onclick="location.href='list.jsp'"> <input type="button"
				value="좋아요 " onclick="like()">


			</td>
		</tr>
	</table>
	<hr>
	<form method="post" action="re_write_ok.jsp">
	<input type = "hidden" name = "b_idx" value="<%=b_idx %>">
		<p><%=userid%>(<%=name%>):<input type="text" name="re_content">
			<button>확인</button>
		</p>
	</form>
	<hr>
	
	<%
	
	try {
		conn = Dbconn.getConnection();
		if (conn != null) {

			
			
			
			String sql = "select * from tb_reply where re_boardidx=? order by re_idx asc ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	while(rs.next()){
		String re_name = rs.getString("re_name");	
		String re_idx = rs.getString("re_idx");	
		String re_userid = rs.getString("re_userid");	
		String re_content = rs.getString("re_content");	
		String re_regdate = rs.getString("re_regdate");	
		
	%>	
	
	<p>👉 <%=re_userid %>(<%=re_name %>) : <%=re_content %> (<%=re_regdate %>)
	<%
	if(re_userid.equals(userid)){
	%>
	<input type ="button" value = "삭제" onclick ="replyDel(<%=re_idx%>,<%=b_idx%>)">
	<% } %>
	
	</p>
	
	<%
	
	}
	
	%>
	
	
</body>
</html>

































