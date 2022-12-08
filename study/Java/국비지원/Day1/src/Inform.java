public class Inform {
    public static void main(String[] args) {
        int i = 3, k = 1;
        switch (i) {// i는 3이다 -> case 3으로 이동
            case 1:
                k += 1;
            case 2:
                k++;
            case 3:// k는 3부터 시작하여 초기값은 0으로 시작
                k = 0;
            case 4:
                k += 3; // 0 + 3 = 3
            case 5:
                k -= 10; //3 - 10 = -7
            default : k--; // k는 지금 -7 후위 연산자이기 때문에
        }
        System.out.println(k); // 연산이 끝나고 -8이 나온다.
    }
}
