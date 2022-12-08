public class Operator3 {
    public static void main(String[] args) {
        int var1 = 10, result =10;
        System.out.println("현재 var1의 값: "+var1);//+ 연결 연산자 10
        System.out.println("현재 var2의 값: "+ ++var1);//11
        System.out.println("현재 var2의 값: "+ var1);//11
        System.out.println("현재 var2의 값: "+ var1++);//11->12
        System.out.println("현재 var2의 값: "+ ++var1);//13

        result = result++;// result에 이미 저장하였기 떄문에 후위연산 없이 10이 나온다.
        System.out.println("현재 result의 값 : "+result);//reuslt를 그저 대입 이콜이 아니다.
        System.out.println("현재 result의 값 : "+result);

    }
}
