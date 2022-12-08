public class User {//클래스 생성
    String id;// this. : 현재 내 클래스에 있는 필드이다.
    String name;
    String password;
    int age;
    double point;

    User(String id, String name){
//        this.id = id;
//        this.name = name;
//        this.password = "😁";
//        this.age = 10000;
//        this.point = 1000;
        this(id,name, "😁",10000,1000);
    }

    //생성자
    User(){// 객체User user = new User();가 생길 때 생성자 출력
        System.out.println("👍");
        id = "no_id";
        name = "무명";
        password = "00000";
        age = 0;
        point =0;
    }

    User(String id, String name, String password,int age, double point){
    // 생성자 이름 동일해도 괜찮다. 매개변수의 타입이나 개수가 다르면 괜찮다.
        this.id = id; // this. : 현재 내 클래스에 있는 필드이다.
        this.name = name; // 흰색 nmae은 매개변수
        this.password = password;
        this.age = age;
        this.point = point;
    }
    public void info(){//메서드 생성 : 행동
        System.out.println("[아이디 : "+id + ", 이름은 : "+name+
                ", 비밀번호 : "+password+", 나이 :"+age+", 포인트 : "+point);
    }
}
