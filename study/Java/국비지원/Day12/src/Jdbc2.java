import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
//문제. jdbc1을 참고하여 jdbc2 클래스에 회원가입 수정 프로그램을 작성해보자
//        1. 아이디를 기준으로 수정
//        2. sql 쿼리를 저장할 객체는 StringBuilder 사용
public class Jdbc2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/aidev?useSSL=false";
        String uid = "root";
        String upw = "1234";

        Scanner sc = new Scanner(System.in);
        System.out.println("😊😊😊😊😊 회원수정😊😊😊😊😊");
        System.out.println("변경할 아이디를 입력하세요 > ");
        String mem_userid = sc.next();
        System.out.println("비밀번호를 입력하세요 > ");
        String mem_userpw = sc.next();
        System.out.println("이름을 입력하세요 > ");
        String mem_name = sc.next();
        System.out.println("휴대폰번호를 입력하세요 > ");
        String mem_hp = sc.next();
        System.out.println("이메일 입력하세요 > ");
        String mem_email = sc.next();
        System.out.println("성별을 입력하세요 > ");
        String mem_gender = sc.next();
        System.out.println("취미를 입력하세요 > ");
        String mem_hobby = sc.next();
        System.out.println("주민등록번호 앞자리를 입력하세요 > ");
        String mem_ssn1 = sc.next();
        System.out.println("주민등록번호 뒷자리를 입력하세요 > ");
        String mem_ssn2 = sc.next();
        System.out.println("우편번호를 입력하세요 > ");
        String mem_zipcode = sc.next();
        System.out.println("주소를 입력하세요 > ");
        String mem_address1 = sc.next();
        System.out.println("상세주소를 입력하세요 > ");
        String mem_address2 = sc.next();
        System.out.println("참고사항을 입력하세요 > ");
        String mem_address3 = sc.next();

        StringBuilder sql = new StringBuilder();
        sql.append("update tb_member set ")
                .append("mem_userpw ='"+ mem_userpw+ "', ")
                .append("mem_name ='"+ mem_name+ "', ")
                .append("mem_hp ='"+ mem_hp+ "', ")
                .append("mem_email ='"+ mem_email+ "', ")
                .append("mem_gender ='"+ mem_gender+ "', ")
                .append("mem_hobby ='"+ mem_hobby+ "', ")
                .append("mem_ssn1 ='"+ mem_ssn1+ "', ")
                .append("mem_ssn2 ='"+ mem_ssn2+ "', ")
                .append("mem_zipcode ='"+ mem_zipcode+ "', ")
                .append("mem_address1 ='"+ mem_address1+ "', ")
                .append("mem_address2 ='"+ mem_address2+ "', ")
                .append("mem_address3 ='"+ mem_address3+ "' where mem_userid=' "+mem_userid+"'");

   System.out.println(sql);

        try {
            // class 라는 이름을 가진 클래스는 jvm에서 동작할 클래스들의 정보를 묘사하는 일종의 메타클래스
            // DB와 연결할 드라이바 클래스를 찾아서 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, uid, upw);
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql.toString());
            if(result >= 1) System.out.println("회원가입이 완료되었습니다");
            else System.out.println("회원가입에 실패하였습니다");
        } catch (ClassNotFoundException e) {//Class.forName에 해당하는 예외처리를 해줘야한다
            e.printStackTrace();
        } catch (SQLException e){//SQL Server에서 경고 또는 오류를 반환할 때 throw되는 예외이다.
            e.printStackTrace();
        }
    }
}