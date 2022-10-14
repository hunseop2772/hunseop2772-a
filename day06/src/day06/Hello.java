package day06;

public class Hello {

	public static void main(String[] args) {

		String s = "Hello";
		int i=3;
		float f =3.14f;
		double d = 3.14;
		char c='a';
		System.out.println(s instanceof String);//저 s가 스트링으로 만들어진건가요??
		System.out.println(Integer.valueOf(i) instanceof Integer);// instanceof 다음 대문자!
		System.out.println(Float.valueOf(f) instanceof Float);
		System.out.println(Double.valueOf(d) instanceof Double );
		System.out.println(Character.valueOf(c) instanceof Character );
		
		
	}

}
