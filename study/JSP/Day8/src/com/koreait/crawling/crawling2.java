package com.koreait.crawling;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class crawling2 {

	public static void main(String[] args) {
		String url ="https://music.bugs.co.kr/chart";
		
		Document doc = null;
		
		try { 
		doc = Jsoup.connect(url).get();
//		System.out.println("접속성공!");
//		System.out.println(doc.html());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		Elements elements = doc.select("table.byChart");
		Iterator<Element> title = elements.select("p.title").iterator();
		Iterator<Element> artist = elements.select("p.artist").iterator();
		
		int rank =1;
		while(title.hasNext()) {
			System.out.println(rank+"위 "+artist.next().text()+"-"+title.next().text());
			rank++;
		}
		
	}

}
