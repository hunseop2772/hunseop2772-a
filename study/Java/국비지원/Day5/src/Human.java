public class Human {
    /*
현실세계에 있는 Object를 선택하여 클래스로 설계하고 데이터를 입력하여 이를 출력하는 프로그램을 만들어보자.
(단, 클래스에는 생성자 및 getter/setter 메소드를 포함해야 하며 생성자는 오버로딩되어 여러개를 생성)
    */
    private int age;
    private String blood;
    private String name;
    private String gender;

    Human() {
        System.out.println("✔");
        age = 27;
        blood = "O+";
        name = "Song";
        gender = "man";
    }

    Human(int age, String blood, String name, String gender) {
        this.age = age;
        this.blood = blood;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void info() {//메서드 생성 : 행동
        System.out.println("[나이 : " + age + ", 혈액형 : " + blood +
                ", 이름 : " + name + ", 성별 :" + gender + "]");
    }

}
