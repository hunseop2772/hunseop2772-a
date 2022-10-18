import java.sql.*;
import java.util.Scanner;

public class Jdbc1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/aidev?useSSL=false";
        String uid = "root";
        String upw = "1234";

        Scanner sc = new Scanner(System.in);
        System.out.println("😊😊😊😊😊 회원가입 😊😊😊😊😊");
        System.out.println("아이디를 입력하세요 > ");
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
        String sql = "insert into tb_member (mem_userid, mem_userpw, mem_name, ";
        sql += "mem_hp, mem_email, mem_gender, mem_hobby, mem_ssn1, mem_ssn2, ";
        sql += "mem_zipcode, mem_address1, mem_address2, mem_address3) values (";
        sql += "'"+mem_userid+"', '"+mem_userpw+"', '"+mem_name+"', ";
        sql += "'"+mem_hp+"', '"+mem_email+"', '"+mem_gender+"', ";
        sql += "'"+mem_hobby+"', '"+mem_ssn1+"', '"+mem_ssn2+"', ";
        sql += "'"+mem_zipcode+"', '"+mem_address1+"', '"+mem_address2+"', ";
        sql += "'"+mem_address3+"')";

//        System.out.println(sql);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//sql 패키지를 가저오자
            Connection conn = DriverManager.getConnection(url, uid, upw);
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if(result >= 1) System.out.println("회원가입이 완료되었습니다");
            else System.out.println("회원가입에 실패하였습니다");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){//연결이 안되었을때는(getConnection 빨간줄 생성)
            e.printStackTrace();
        }
    }
}