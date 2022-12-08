public class Method1 {
//    //객체를 생성해서 사용해야함
//    public void method1() {
//        System.out.println("Hello java!");
//    }

    public static void method1(){
        System.out.println("Hello java!");
    }
    //static 사용시 바로 메모리에 올리기 때문에 힙에 따로 올릴필요 없다.

    public static void main(String[] args) {
//        Method1 method1 = new Method1();//힙에 올리기 위해 참조변수를 불러 사용
//        method1.method1();
        System.out.println("안녕하세요");
        method1();//메소드 호출 프로그램은 위에서 아래로 왼쪽에서 오른쪽으로 진행한다고 생각하자.
        System.out.println("프로그램을 종료합니다.");
        //클래스명.메소드명); 다른 클래스에 있는 메소드 사용하기 위해
    }
}
