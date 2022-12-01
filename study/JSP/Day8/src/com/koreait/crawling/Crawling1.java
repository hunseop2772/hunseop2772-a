package com.koreait.crawling;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawling1 {

	public static void main(String[] args) {
		String url ="http://www.cgv.co.kr/movies/";
//		System.out.println("접속주소: "+url);
		
		Document doc = null;
		
		try { 
		doc = Jsoup.connect(url).get();
//		System.out.println("접속성공!");
//		System.out.println(doc.html());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		Elements elements = doc.select("div.sect-movie-chart");
		Iterator<Element> rank = elements.select("strong.rank").iterator();
		Iterator<Element> title = elements.select("strong.title").iterator();
		
		while(rank.hasNext()) {
			System.out.println(rank.next().text()+":"+title.next().text());
		}
		
	}

}
