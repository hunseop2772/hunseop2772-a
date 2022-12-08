public class Oop3Task {
    public static void main(String[] args) {
        Human h = new Human();
        h.info();
        h.setName("송sd");
        h.setBlood("0형");
        h.setAge(Integer.parseInt("1234"));
        h.setGender("남자");
        h.info();

        Human h1= new Human(5,"A","HUN","Woman");
        System.out.println(h.getName());
        h1.info();
        System.out.println(h1.getName());
        Human h2 = new Human();
        h2.info();
    }
}
