import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/test?ussSSL=false";
        String uid = "banana";
        String upw = "2222";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //오류시 밑에있는 출력은 안나온다.
            System.out.println("드라이버가 로드되었습니다.");

            Connection conn =DriverManager.getConnection(url, uid, upw);//connection 객체를 리턴
            // Connection 객체는 연결이 된 상태에서 sql구문을 사용한다.
            // DriverManager은 연결을 의미한다.
            System.out.println("MySQL 서버에 정상적으로 연결되었습니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
