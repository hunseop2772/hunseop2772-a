package day03;

public class DataType {

	public static void main(String[] args) {
		int a = 65;// 묵시적형변환(자동으로 변환)
		float f = a;
		System.out.println(f);
		char c = (char)a;//명시적 형변환(강제 형변환)
		System.out.println(c);

	}

}
