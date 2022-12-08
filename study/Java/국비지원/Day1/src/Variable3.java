public class Variable3 {
    public static void main(String[] args) {
        char var1 ='A';// 자바에서 유니코드(2byte) 사용하기 떄문에 A 한글자만 사용가능
        char var2 = '가';//2byte  ''-1글자 ""-2글자
        System.out.println(var1);
        System.out.println(var2);

        char var3 =100; // 숫자 저장도 가능하다. 2byte까지
        System.out.println(var3); // 100과 메핑하는 숫자로 출력한다.
    }
}
