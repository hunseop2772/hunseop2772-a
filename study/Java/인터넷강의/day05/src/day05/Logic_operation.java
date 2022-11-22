package day05;

public class Logic_operation {

	public static void main(String[] args) {
		boolean a=true; //노라형 변수애 참 저장
		boolean b=false;
		boolean c=true;
		System.out.println(a&&b);//a,b 전부 참이어야 참
		System.out.println(a&&c);
		System.out.println((2<4)&&(4<5));
		System.out.println(a||b);//a,b 둘중 하나만 참이면 참
		System.out.println(a^b);// 서로 달라야 참 즉 1
		
		System.out.println(!a);// a가 true이면 flase
		
		

	}

}
