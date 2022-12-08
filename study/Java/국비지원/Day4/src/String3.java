import java.util.Scanner;
//문자로 입력받아 숫자와 현산 후 합 구하기

public class String3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 숫자를 입력");
        String num = sc.next();
        int result = 0;
        for (int i = 0; i < num.length(); i++) {// 내가 원하는 숫자만큼 출력
            System.out.print(num.substring(i, i + 1) + " ");//0 1까지
            result += Integer.parseInt(num.substring(i, i + 1));
        }
        System.out.println();
        System.out.println(result);
        System.out.println(Integer.parseInt(num.substring(1, 2)));// 1에서 1까지니깐 1자리 수 출력

    }
}
