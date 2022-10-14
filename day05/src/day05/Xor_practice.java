package day05;

public class Xor_practice {

	public static void main(String[] args) {
		int a=15;// 1111
		int b=5;//0101
		//비트 논리연산자
		System.out.println(a&b); //0101
		System.out.println(a|b);//1111
		
		System.out.println(a^b);//1010
		System.out.println(~b);
		//비트 쉬프트 연산자
		System.out.println(a>>2);    
		System.out.println(b<<4);
		    
	}  
}