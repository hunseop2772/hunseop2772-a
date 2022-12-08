public class Mehtod3 {

    public static String method1(){
        return "❤";
    }
    public static int method2(){//메소드 안에서 만든것은 메소드 종료 시 끝난다.
        int num = (int)(Math.random()*6+1);
        return num;//별도의 num이다.
    }
    public static int[] method3(){
        int[] jumsu = {90,80,100,40,70};
        return jumsu;
    }
    public static int method4(int[] values){
        int sum=0;
        for(int val : values){
            sum+=val;
        }
        return sum;
    }
    public static int method5(int... values){
        int sum=0;
        for(int val : values){
            sum+=val;
        }
        return sum;// 반환타입이 있으면 return
    }
    public static void main(String[] args) {
        System.out.println(method1());
        String present = method1();
        System.out.println(present);
        int num =  method2(); // 같은 num이 아니다.
        System.out.println(num);
        System.out.println("주사위 숫자"+ method2());
        System.out.println(method3());// 주속값만 출력된다.
        int[] jumsu = method3();//배열식으로 받아야한다.
        for(int i : jumsu){
            System.out.print(i + " ");
        }
        System.out.println();
        int[] values = {10,20,30,40};
        int result = method4(values);
        System.out.println(result);

        result = method5(10,20,30,40,50,60);//매개변수가 얼마나 있는지 모를때
        System.out.println(result);
    }
}
