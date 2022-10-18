import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc5 {
    public static void main(String[] args) {
        System.out.println("😁회원목록😁");
        StringBuilder sql = new StringBuilder();
        sql.append("select * from tb_member");// *로 했기 때문에 다른 모든것을 가저올 수 있다.
        try{
            Connection conn = Dbconn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();// sql에서 테이블을 받아오는 것이다. Resultset에 담아짐
            while(rs.next()) {//처음 컬럼이아닌 필드를 가리키고 있어서 다음 커서인 컬럼을 가리킨다.
                // 꺼내오는 방법은 필드명이다.
                int mem_idx = rs.getInt("mem_idx");// 첫 번쨰 mem_idx를 저장
                String mem_userid = rs.getString("mem_userid");
                String mem_name = rs.getString("mem_name");
                String mem_hp = rs.getString("mem_hp");
                System.out.println("번호 : "+ mem_idx+", 아이디 : "+mem_userid+", 이름 : "+mem_name+", 휴대폰번호 : "+mem_hp);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
