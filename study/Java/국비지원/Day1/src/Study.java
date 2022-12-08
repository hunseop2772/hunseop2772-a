import java.sql.SQLOutput;

public class Study {
    public static void main(String[] args) {
        int kor = 80, math = 70, com= 100;
        int sum = kor + math + com;
        double avg =(kor + math + com)/3.0;
        System.out.println("총점 : "+ sum+ " 평균 : "+avg);
        String result = (avg >= 10) ? "합격" : "불합격";
        System.out.println(result+ "입니다.");

    }
}
