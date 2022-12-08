public class Operator1 {
    public static void main(String[] args) {
        int var1 = 10, var2 = 3;
        int result = var1 + var2;
        System.out.println(result);

        result = var1 - var2;
        System.out.println(result);

        result = var1* var2;
        System.out.println(result);
/*
정수 / 정수 = 정수
실수 / 정수 = 실수
정수 / 실수 = 실수
실수 / 실수 = 실수
 */
        result = var1/var2;
        System.out.println(result);

        double result2 = var1/var2;
        System.out.println(result2);

        result2 = var1/3.0;
        System.out.println(result2);

        result = var1%var2;
        System.out.println(result);
    }
}
