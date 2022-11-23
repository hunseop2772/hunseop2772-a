<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/sessioncheck.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>


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
<%

String sql = "select count(b_idx) as coun from tb_board  ";
pstmt = conn.prepareStatement(sql);
ResultSet rs1 = pstmt.executeQuery();
String replyCnt1 = "";
if(rs1.next()){
	
	int coun = rs1.getInt("coun");
	if(coun > 0){
		replyCnt1 = "[" + coun + "]";
	}

sql = "select timestampdiff(day, now(), ?) from tb_reply;";
int re_regdate = rs.getInt("re_regdate");

pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, re_regdate );
rs = pstmt.executeQuery();

if(rs.next()){
	
	String m = "new";


	
}

%>


	<h2>리스트</h2>
	<p>총 게시글 : <%=replyCnt1 %> 개</p>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>날짜 </th>
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
		
		sql = "select count(re_idx) as cnt from tb_reply where re_boardidx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			ResultSet rs_reply = pstmt.executeQuery();
			
			String replyCnt = "";
			if(rs_reply.next()){
				
				int cnt = rs_reply.getInt("cnt");
				if(cnt > 0){
					replyCnt = "[" + cnt + "]";
				}
			}
	%>	
		
		<tr>
			<td><%=b_idx %></td>
			<td ><a href ="view.jsp?b_idx=<%=b_idx%>"><%=b_title %></a><%=replyCnt%></td>
			<td><%=b_userid %>(<%=b_name %>)</td>
			<td><%=b_hit %></td>
			<td><%=b_regdate %> (<%=re_regdate %>)</td>
			<td><%=b_like %></td>
		</tr>
		<%} %>
	</table>
	<p><a href = "write.jsp">글쓰기</a> <a href ="../login.jsp">돌아가기</a></p>
</body>
</html>