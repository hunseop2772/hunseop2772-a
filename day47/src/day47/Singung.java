package day47;

import java.util.Scanner;

public class Singung {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ip =0, money1 =0, money2 =0;
		
		System.out.println("------코인 노래방 프로그램-------");
		System.out.println("한 곡당 300원");
		System.out.print("금액을 입력해주세요 : ");
		ip = sc.nextInt();
		money1 = ip/300;
		money2 = ip%300;
		System.out.println(money1 + "곡을 부를 수 있으며 잔돈은"+ money2+ "원 입니다.");
		
		
	}

}
