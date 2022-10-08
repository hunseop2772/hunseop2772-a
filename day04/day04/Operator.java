package day04;

public class Operator {

	public static void main(String[] args) {
		System.out.println(a+b); 
		System.out.println(a-b); 
		System.out.println(a*b); 
		System.out.println(a/b); 
		System.out.println(a%b);
		
		System.out.println(a/doubleB); 
		System.out.println(a%doubleB); 
		System.out.println(doubleB/a); 
		
		int a =1
        a++;//후위
		++a;//전위
		
		System.out.println(a); 
		System.out.println(a++); 
		System.out.println(++a); 
		
		//true / false 나옴
		System.out.println(a<b);
		System.out.println(a>b);
		System.out.println(a+b<=c);
		System.out.println(a+b>=c);
		System.out.println(a==b);
		System.out.println(a!=b);
		
		String c1 = "Hello Java!"
	    System.out.println(c1 == "Hello Java!");//true
		System.out.println(c1.equals("Hello Java!"));
		//문자열 비교시 == 등가비교연산자를 사용하지 않는다. equals 사용
		System.out.println(c1.equals(hello java!));//대소문자 구분가능

	}

}
