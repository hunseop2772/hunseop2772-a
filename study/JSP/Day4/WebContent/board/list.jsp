<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/sessioncheck.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>


<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			String sql = "select * from  tb_board order by b_idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
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
	<h2>list</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>날짜</th>
			<th>좋아요</th>
		</tr>
		
	<%
	while(rs.next()){
		String b_idx = rs.getString("b_idx");
		String b_title = rs.getString("b_title");
		String b_userid = rs.getString("b_userid");
		String b_name = rs.getString("b_name");
		String b_regdate = rs.getString("b_regdate");
		String b_hit = rs.getString("b_hit");
		String b_like = rs.getString("b_like");
	%>	
		
		<tr>
			<td><%=b_idx %></td>
			<td ><a href ="view.jsp?b_idx=<%=b_idx%>"><%=b_title %></a></td>
			<td><%=b_userid %>(<%=b_name %>)</td>
			<td><%=b_hit %></td>
			<td><%=b_regdate %></td>
			<td><%=b_like %></td>
		</tr>
		<%} %>
	</table>
	<p><a href = "write.jsp">글쓰기</a> <a href ="../login.jsp">돌아가기</a></p>
</body>
</html>