package day06;

import java.util.Scanner;

public class Traffic_Lights {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("신호등 프로그램");
  
    System.out.println("빨간색:1, 초록불:2, 노란불");
    System.out.println("신호 : ");
    int sign = sc.nextInt();// 신호번호를 입력받는다.
    switch(sign) {
    case 1 :
    	System.out.println("빨간불입니다. 정지하세요");
    	break;
    case 2 :
    	System.out.println("노란불입니다. 천천히");
    	break;
    case 3 :
    	System.out.println("초록불. 고고");
    	break;
    	default:
    		System.out.println("잘못눌렀습니다.");
    }
    
	}

}
