/*
SQL 문
use aidev;
create table tb_mv(
m_idx int not null auto_increment primary key,
m_title varchar(50),
m_score int, 
m_review varchar(1000)
);

select * from tb_mv;*/





package com.koreait.crawling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.koreait.db.Dbconn;

public class Mcrawling {
	public static void main(String args[]) {
		for(int i=1; i<11; i++) {
		String url = "https://movie.naver.com/movie/point/af/list.naver?&page=" +" str(i)";
	
		Document doc = null;
		
		try { 
			doc = Jsoup.connect(url).get();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select("table.list_netizen");
		
		Iterator<Element> moviename = element.select("a.movie").iterator();
		Iterator<Element> scores = element.select("div.list_netizen_score").iterator();
		Iterator<Element> content = element.select(".title").iterator();
		int idx=0;
	
	
		
		
		
		while(moviename.hasNext()) {

			String movienames = moviename.next().text();

			String scores2=scores.next().text();
			scores2=scores2.substring(12);
			int score =Integer.parseInt(scores2);

			String content2 = content.next().text();
			idx = content2.indexOf("중");
	
			content2 = content2.replaceAll("신고", "");
			
			
			Connection conn = null;
			

			
			PreparedStatement pstmt = null;
				try {
				
					String m_title = movienames;
					int  m_score = score;
					String m_review = content2;
				String	sql = "insert into tb_mv(m_title, m_score, m_review) values ( ?, ?, ?)";
				conn = Dbconn.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, m_title);
					pstmt.setInt(2, m_score);
					pstmt.setString(3, m_review);
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			System.out.println("영화 제목 : "+movienames + "별점 :"+score + "점 리뷰내용 :" + content2);
			
		}		
		
	}
	}
}