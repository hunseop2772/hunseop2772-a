package dya14;

import java.util.Scanner;

public class Day14_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int scores[][] = new int[4][3];
		String subject[] = {"국어", "영아", "수학"};
		
	    
		for(int j=0;j<4;j++) {
			System.out.println((j+1) + "번 학생의 점수");
	    for(int i =0; i<3;i++) {
		System.out.print(subject[i]+":");
		scores[j][i] = sc.nextInt();
		}
	}
		//2차원 배얄에 지정된 값을 출력
	    for(int i =0; i<3;i++) {
	    	System.out.print("\t"+subject[i]);
	    }
	    System.out.println();
	    for(int j=0;j<4;j++) {
	    	System.out.print(j+1+"번:\t");
	    	for(int i=0;i<3;i++) {
	    		 System.out.print(scores[j][i] + "\t" );
	    	}
	    	System.out.println();
	    }
	    
	}
}


