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
 * Servlet implementation class delete_write_ok
 */
@WebServlet("/delete_write_ok")
public class delete_write_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_write_ok() {
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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String b_idx = request.getParameter("b_idx");

		String userid = (String) session.getAttribute("userid");

	

		try {
			conn = Dbconn.getConnection();
			if (conn != null) {
				/* 	http://localhost:9090/Day4/board/delete_ok.jsp?b_idx=8  URL로 삭제하는 방법*/
				String sql = "delete from tb_board where b_idx =? and b_userid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b_idx);
				pstmt.setString(2, userid);
				pstmt.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setCharacterEncoding("UTF-8");
		writer.println("<script>alert('삭제되었습니다.');location.href='./list.jsp';</script>" );
	}

}
