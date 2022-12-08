public class Student {
    private int no;
    private String name;
    private String hp;
    private String address;
    private String blood;
    private String mbti;
    // class의 은닉성을 위해 메서드로 선언해준다.

    //우클릭 -> Generate -> Getter and Setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public void info() {//메서드 생성 : 행동
        System.out.println("[아이디 : " + no + ", 이름은 : " + name + ", 비밀번호 : " + address + ", 나이 :" + blood + ", 포인트 : " + mbti);
    }
}
