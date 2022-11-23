<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>

<%@ include file="./include/sessioncheck.jsp"%>

<%!public static boolean compareHobby(String[] arr, String item) {
		for (String i : arr) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}%>
<%
	/* 		String idx = (String)session.getAttribute("idx"); 
			idx를 사용하여 검색하면 인덱싱이 되어있어 속도가 유리하다*/
	String userid = (String) session.getAttribute("userid");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String mem_name = "";
	String mem_hp = "";
	String mem_email = "";
	String[] hobbyArr = null;
	String mem_ssn1 = "";
	String mem_ssn2 = "";
	String mem_zipcode = "";
	String mem_address1 = "";
	String mem_address2 = "";
	String mem_address3 = "";
	String mem_gender = "";

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			// *는 절대 사용하지 말것 개인적으로 편의를 위해 사용함
			String sql = "select * from tb_member where mem_userid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem_name = rs.getString("mem_name");
				mem_hp = rs.getString("mem_hp");
				mem_email = rs.getString("mem_email");
				hobbyArr = rs.getString("mem_hobby").split(" ");
				mem_ssn1 = rs.getString("mem_ssn1");
				mem_ssn2 = rs.getString("mem_ssn2");

				mem_zipcode = rs.getString("mem_zipcode");
				mem_address1 = rs.getString("mem_address1");
				mem_address2 = rs.getString("mem_address2");
				mem_address3 = rs.getString("mem_address3");
				mem_gender = rs.getString("mem_gender");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>정보수정</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script defer src="./js/info.js"></script>
</head>
<body>
	<h2>정보수정</h2>
	<form action="./info_ok.jsp" name="regform" id="regform" method="post"
		onsubmit="return sendit()">
		<p>
			아이디 :
			<%=userid%>
		</p>

		<p>
			비밀번호 : <input type="password" name="userpw" id="userpw"
				maxlength="20">
		</p>
		<p>
			비밀번호 확인 : <input type="password" name="userpw_re" id="userpw_re"
				maxlength="20">
		</p>
		<p>
			이름 : <input type="text" name="name" id="name" value="<%=mem_name%>">
		</p>
		<p>
			휴대폰 번호 : <input type="text" name="hp" id="hp" value="<%=mem_hp%>">
		</p>
		<p>
			이메일 : <input type="text" name="email" id="email"
				value="<%=mem_email%>">
		</p>
		<p>
			성별 :<label> 남자 <input type="radio" name="gender" value="남자"
				<%if (mem_gender.equals("남자"))
				out.print("checked");%>></label>
			<label> 여자 <input type="radio" name="gender" value="여자"
				<%if (mem_gender.equals("여자"))
				out.print("checked");%>>
			</label>
		</p>
		<p>
			취미 : <label>등산<input type="checkbox" name="hobby" value="등산"
				<%if (compareHobby(hobbyArr, "등산"))
				out.print("checked");%>></label>
			<label>게임<input type="checkbox" name="hobby" value="게임"
				<%if (compareHobby(hobbyArr, "게임"))
				out.print("checked");%>></label>
			<label>영화감상<input type="checkbox" name="hobby" value="영화감상"
				<%if (compareHobby(hobbyArr, "영화감상"))
				out.print("checked");%>></label>
			<label>드라이브<input type="checkbox" name="hobby" value="드라이브"
				<%if (compareHobby(hobbyArr, "드라이브"))
				out.print("checked");%>></label>
			<label>운동<input type="checkbox" name="hobby" value="운동"
				<%if (compareHobby(hobbyArr, "운동"))
				out.print("checked");%>></label>
		</p>
		<p>
			주민등록번호 : <input type="text" name="ssn1" value="<%=mem_ssn1%>">
			-<input type="text" name="ssn2" value="<%=mem_ssn2%>">
		</p>


		<p>
			우편번호: <input type="text" name="zipcode" maxlength="5"
				id="sample6_postcode" value="<%=mem_zipcode%>">
			<button type="button" onclick="sample6_execDaumPostcode()">검색</button>
		</p>
		<p>
			주소 <input type="text" name="address1" id ="sample6_address"
				value="<%=mem_address1%>">
		</p>
		<p>
			상세주소 <input type="text" name="address2" id ="sample6_detailAddress"
				value="<%=mem_address2%>">
		</p>
		<p>
			참고사항 <input type="text" name="address3" id ="sample6_extraAddress"
				value="<%=mem_address3%>">
		</p>
		<p>
			<button>수정완료</button>
			<button type="reset">다시작성</button>
			<button type="button" onclick="location.href='login.jsp'">돌아가기</button>
		</p>
	</form>



</body>
</html>
