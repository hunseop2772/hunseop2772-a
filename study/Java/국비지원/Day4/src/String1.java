public class String1 {
    public static void main(String[] args) {
        String str1 = new String("apple");//String 객체 생성
        String str2 = new String("apple");//객체 생성방식으로 사용하면 서로 같지 않다.
        // 주소비교가 되기 때문이다.
        String str3 = "apple";//리터럴 표기로 생성 - 값을 직접 변수에 참조하는 방식을 의미한다.
        String str4 = "apple";// string은 생긴거와 달리 전부 힙에 저장된다. 클래스
        //리터럴 표기는 같은 값을 입력할 경우 힙 영역에서 스캔하여 동일한 값이 있는지 확인 후
        // 같으면 주소를 동일하게 사용한다. 그렇기 떄문에 리터럴 값은 동일하면 동일하다.
        // 메모리 절약사용 및 편의성 -> String은 불변객체로 수정소요를 줄일 수 있도록하자 -> 메모리 사용 多

        str3 = "banana";// 값을 수정하면 수정할 수록 메모리가 찬다. 리터널이든 객체생성이든 동일하다.
        str3 = "orange";
        str4 = "orange";
        // 널포인트 익셉션 : 변수가 참조변수가 가르키는에가 없는경우

        System.out.println(str1 == str2);//F
        System.out.println(str3 == str4);//T
        System.out.println(str1 == str4);//F
        System.out.println(str1.equals(str2));//T
    }
}