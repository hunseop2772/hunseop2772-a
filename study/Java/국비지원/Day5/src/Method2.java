public class Method2 {
    public static void method2(int num){
        System.out.print("매개변수로 전달된 값 : ");
        System.out.println(num);
    }
    public  void method2(int num1, int num2){
        System.out.println(num1*num2);
    }
    public  static void method3(int start, int end){
        int sum=0;
        for(int i=start; i<=end;i++){
            sum+=i;
        }
        System.out.println(start+"부터 "+end+"까지의 합 : "+ sum);
    }
    public static void main(String[] args) {
        method2(10);// 개수와 타입이 동일해야한다.
        method2(14);// 동일한 메소드명을 사용해도 문제는 없다.
        Method2 method2 = new Method2();
        method2.method2(10,20);
        method3(1,10);
        method3(50,100);
        method2(10);// 개수와 타입이 동일해야한다.
    }
}
