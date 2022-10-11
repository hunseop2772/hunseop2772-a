package day45_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day45_1 {

	public static void main(String[] args) throws IOException{
		FileInputStream fis = null;//입력스트림
		FileOutputStream fos = null;//출력스트림
		fis = new FileInputStream("prac.txt");//존재하는 파일과 연결
		fos = new FileOutputStream("result.txt");//존재하지 않으며 파일 생성, 존재하면 파일 덮음
		
		BufferedInputStream bis = new  BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int data;
		while((data=fis.read())!=-1) {
			
			bos.write(data);
		}//파일과의 연결을 닫는 작업
		bos.close();
		bis.close();
		
	}

}
