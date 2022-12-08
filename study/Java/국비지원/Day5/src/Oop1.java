public class Oop1 {
    public static void main(String[] args) {
        User user1 = new User();// 객체가 생길 때 생성자 출력
        user1.info();// 초기값
//메인메서드에서 확인
        user1.id = "apple";
        user1.name = "김사과";
        user1.password = "1111";
        user1.age = 20;
        user1.point = 100;

        user1.info();// 데이터를 채움
        System.out.println(user1.name);// 이름만 출력을 원한다면
//동일한 메서드에서 참조변수 변경해서 사용할 수 있다.
        User user2 = new User();// 객체가 생길 때 생성자 출력
        user2.info();// 생성자의 값을 받는다.
        user2.id ="banana";
        user2.name ="반하나";//직접 입력하기에는 적절하지는 않다.
        user2.password ="2222";
        user2.age =27;
        user2.point =20;
        user2.info();

        User user3 = new User("Orange","오렌지","3333",30,10);//생성지
        // 생성자 유형이 같은(매개변수 수, 형태에 따라) 호출한다.
        user3.info();
        User user4 = new User("mellon","이메론");
        user4.info();

    }
}
