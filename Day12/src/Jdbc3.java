import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("😢😢😢😢 회원탈퇴 😢😢😢😢");
        System.out.println("탈퇴할 아이디를 입력하세요");
        String mem_userid = sc.next();


        StringBuilder sql = new StringBuilder();
        sql.append("delete from tb_member ")
                .append("where mem_userid='" + mem_userid + "'");

        try{
            Connection conn = Dbconn.getConnection();
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql.toString());
            if(result>=1) System.out.println("탈퇴되었습니다.");
            else System.out.println("탈퇴 실패되었습니다.");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
