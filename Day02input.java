package day02;
import java.util.Scanner;
//1.준입물 : 입력기능을 내코드에 연결시켜줘
public class Day02input {

	public static void main(String[] args) {
		// 2.준비물 : scanner를 sc(이름설정)라는 이름으로 사용
		Scanner sc = new Scanner(System.in);
		//sc.next();//문자열로 입력받아라 -> 기능자체가 키보드로 입력한것
		//System.out.println(sc.next()); -> 문자열일뿐 띄어쓰기는 불가능한다
		//System.out.println(sc.nextLine()); -> 문자열 띄어쓰기까지
		sc.nextInt();//정수
		System.out.println(sc.nextInt());
		sc.nextFloat();//
		System.out.println(sc.nextFloat());
		

	}

}
