import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTask {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/aidev?ussSSL=false";
        //mysql> create user 'song'@'%' identified by '2772';
        //mysql> grant all privileges on aidev.* to 'song'@'%';
        String uid = "song";
        String upw = "2772";
        String sql = "insert into tb_member (mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_ssn1, mem_ssn2) values ('hunseop', '2772', 'gnstjq', '010-456-4145', 'gnstjq@gnstjq.com', '231545', '41515')";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //오류시 밑에있는 출력은 안나온다.
            Connection conn = DriverManager.getConnection(url, uid, upw);//connection 객체를 리턴
            // Connection 객체는 연결이 된 상태에서 sql구문을 사용한다.
            // DriverManager은 연결을 의미한다.

            Statement stmt = conn.createStatement();// sql을 다룰 수 있는 상태로 만듬
            int cnt = stmt.executeUpdate(sql);// String을 입력하지만 받아오는것은 int형이다. 얼마나 업데이트 되었는지?
            if (cnt >= 1) System.out.println(cnt + "개의 레코드가 삽입되었습니다.");
            else System.out.println("삽입 실패");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
