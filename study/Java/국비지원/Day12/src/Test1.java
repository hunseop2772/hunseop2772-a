import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("😀😀😀😀😀 로그인 😀😀😀😀😀");
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력하세요");
        String mem_userid = sc.next();
        System.out.println("비밀번호를 입력하세요");
        String mem_userpw = sc.next();
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_idx from tb_member where mem_userid=? and mem_userpw=?");

        try{
            Connection conn = Dbconn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1,mem_userid);
            pstmt.setString(2, mem_userpw);
            ResultSet rs = pstmt.executeQuery();// sql에서 테이블을 받아오는 것이다. Resultset에 담아짐
            if(rs.next()) System.out.println("로그인되었습니다");
            else System.out.println("아이디 또는 비밀번호를 확인하세요");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}