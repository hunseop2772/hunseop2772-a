import java.util.Enumeration;
import java.util.Scanner;

public class MethodTsk {
    public static int mehtod1(int num1, int num2) {
        return num1 + num2;
    }

    public static int mehtod2(int num1, int num2) {
        return num1 - num2;
    }

    public static int mehtod3(int num1, int num2) {
        return num1 * num2;
    }

    public static double mehtod4(double num1, double num2) {
        return num1 / num2;// 소수점까지 나오기 때문에 double을 사용한다.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("두 번째 숫자 입력 : ");
        int num2 = sc.nextInt();

        //받아오거나 출력하기 위해 변수를 메소드마다 선언해줘야한다.
        int result1 = mehtod1(num1, num2);
        int result2 = mehtod2(num1, num2);
        int result3 = mehtod3(num1, num2);
        double result4 = mehtod4(num1, num2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

    }
}
