package com.koreait;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class MemberView
 */
@WebServlet("/MemberView")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		JSONObject result = new JSONObject();
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		MemberDAO dao = new MemberDAO();
		Member member = new Member();
		member.setIdx(m_idx);
		member = dao.view(member);
		
		result.put("idx",member.getIdx());
		result.put("name",member.getName());
		result.put("hp",member.getHp());
		result.put("email",member.getEmail());
		
		response.setContentType("application/jspn");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Member 테이블의 멤버정보를 JSON으로 전달하는 프로그램을 작성
		// (단 멤버의 정보를 전달하여 해당 번호의 멤버정보를 출력)
		response.setCharacterEncoding("UTF-8");
		JSONObject result = new JSONObject();
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		MemberDAO dao = new MemberDAO();
		Member member = new Member();
		member.setIdx(m_idx);
		member = dao.view(member);
		
		result.put("idx",member.getIdx());
		result.put("name",member.getName());
		result.put("hp",member.getHp());
		result.put("email",member.getEmail());
		
		response.setContentType("application/jspn");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		
	}

}
