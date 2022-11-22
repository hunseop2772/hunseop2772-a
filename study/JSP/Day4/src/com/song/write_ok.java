package com.song;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.db.Dbconn;

/**
 * Servlet implementation class write_ok
 */
@WebServlet("/write_ok")
public class write_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement pstmt = null;
		

		String userid = (String)session.getAttribute("userid");
		String name = (String)session.getAttribute("name");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");


		try {
			conn = Dbconn.getConnection();
			if (conn != null) {
				String sql = "insert into tb_board(b_userid,  b_name, b_title, b_content)values(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, name);
				pstmt.setString(3, b_title);
				pstmt.setString(4, b_content);
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		writer.println("<script>alert('등록 되었습니다.');location.href='./board/list.jsp';</script>" );

}}
