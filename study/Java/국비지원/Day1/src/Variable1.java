public class Variable1 {
    public static void main(String[] args) {
        byte var1; // 변수의 선언
        var1 = 10; // 변수의 초기화
        byte var2 = 20; // 변수의 선언 및 초기화
        System.out.println(var1);
        System.out.println(var2);
//        byte var3 = 200; error!
//        System.out.println(var3);
        int var4 = 15;
        int var5 = 20;
        int var6 = 30, var7 = 40;
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
        System.out.println(var7);

        long var8 = 100000000000000L; // long형은 숫자 뒤에 L을 표가한다. -> long형 표기
        // 숫자만 사용할 경우 integer로 판단한다.
        System.out.println(var8);

        float var9 = 10.1234F;
        System.out.println(var9);


    }
}
