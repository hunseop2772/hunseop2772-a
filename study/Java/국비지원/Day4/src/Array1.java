import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        //정렬문제
        System.out.println("몇개의 값을 저장할까요?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//5개를 저장한다고 가정
        int [] arr = new int[num];

        for(int i =0; i<arr.length; i++){ // 80 50 70 100 40
            System.out.println((i+1)+"번째 저장할 숫자를 입력하세요");
            arr[i] = sc.nextInt();
        }
        int temp = 0;
        for(int i=0; i<arr.length-1;i++){//-1인 이유는 j랑 비교하는데 끝까지 갈 필요가 없기 때문에 그전에서 멈춘다.
           for(int j=i+1; j<arr.length;j++){
               if(arr[i]>arr[j]){   //앞에가 더 크면 바꾸는것은 오름차순이다.
                   temp = arr[i];// 템프는 에이0
                   arr[i] = arr[j];//에이0은 에이1
                   arr[j] = temp;//에이1은 에이0
               }
           }
        }
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
}
