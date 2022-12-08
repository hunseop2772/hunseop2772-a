import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요 : ");
        String my = sc.next();
        int result = 0;
        int temp=0;
        int temp1 =0;
        int [] num = {2,3,4,5,6,7,8,9,2,3,4,5};
        // 식에서 따로 곱하는 문제가 있어 1차원 배열을 사용하여 값 입력
        for(int i=0; i<my.length()-1;i++) {
        // 마지막 자리는 따로 빼서 사용하기 때문에 곱하고 더하는 식은 마지막자리 제외위해 -1
            System.out.print(my.substring(i, i + 1) + " ");
            // 한자리 숫자끼리 계산하기 때문에 substring 사용
            result += num[i] * Integer.parseInt(my.substring(i, i + 1));
            //String 문자로 입력받은 주민번호를 정수로 바꿔 곱하기
        }
        temp = result%11;
        //나눈값이 저장되기 위해 temp선언 어차피 11미만이면 무시
        temp1 = 11-temp ;
        //11에서 뺀 값을 다시 저장
        if(temp1>=10){
            //10이상인 경우
            temp1 %= 10;
        }
        if(temp1 == Integer.parseInt(my.substring(12, 13))) {
            //마지막 자리가 같으면
            System.out.println("유효한 주민등록번호입니다!");
        }else{
            System.out.println("틀렸습니다.");
        }

    }
}
