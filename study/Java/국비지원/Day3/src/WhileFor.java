public class WhileFor {
    public static void main(String[] args) {
        /*
            🎃를 사용하여 아래와 같이 출력

           1. 🎃🎃🎃🎃🎃

           2. 🎃🎃🎃🎃🎃
              🎃🎃🎃🎃🎃
              🎃🎃🎃🎃🎃
              🎃🎃🎃🎃🎃
              🎃🎃🎃🎃🎃
         */
//        for(int i=1;i<=5;i++){// i =1 일 때 j는 5까지 -> i=2일 때 j는 까지
//            for(int j=1; j<=5;j++){
//                System.out.print("🎃");
//            }// -> i가 1일 때 j를 5까지 사용하고 밑으로 빠지고 다시 1부터 5까지 이동
//            System.out.println();// 띄어쓰고 다시 위로 올라간다.
//        }
//        System.out.println("------------------------------------------------------");
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 5; j >=1; j=j-i) {
//                System.out.print("🎃");
//            }
//            System.out.println();
//        }
        System.out.println("------------------------------------------------------");
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j <=5; j++) {//i,j가 1이면 1줄 5개, 2이면 (2,3,4,5) 4개
                System.out.print("🎃");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <=i; j++) {// j<=i i가 1이면 1줄은 1개 2줄은(1,2) 2개
                System.out.print("🎃");
            }
            System.out.println();
        }
    }
}
