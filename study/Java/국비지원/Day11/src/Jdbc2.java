import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/test?ussSSL=false";
        String uid = "banana";
        String upw = "2222";
        String sql = "insert into product values('0000000099', '인텔리제이', '편해요',160000, now())";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //오류시 밑에있는 출력은 안나온다.
            Connection conn = DriverManager.getConnection(url, uid, upw);//connection 객체를 리턴
            // Connection 객체는 연결이 된 상태에서 sql구문을 사용한다.
            // DriverManager은 연결을 의미한다.

            Statement stmt = conn.createStatement();// sql을 다룰 수 있는 상태로 만듬int cnt = stmt.executeUpdate(sql);// String을 입력하지만 받아오는것은 int형이다. 얼마나 업데이트 되었는지?
            int cnt = stmt.executeUpdate(sql);// String을 입력하지만 받아오는것은 int형이다.
            if (cnt >= 1) System.out.println(cnt + "개의 레코드가 삽입되었습니다.");
            else System.out.println("삽입 실패");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
