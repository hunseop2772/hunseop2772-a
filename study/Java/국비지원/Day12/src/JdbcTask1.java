import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//문제.
//        아이디, 비밀번호를 입력받아 로그인 프로그램을 작성해보자.
//        아이디를 입력하세요 > apple
//        비밀번호를 입력하세요 > 1111
//        로그인 되었습니다. (아이디 또는 비밀번호를 확인하세요)

public class JdbcTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("😁아이디를 입력하세요 >😁");
        String mem_userid = sc.next();
        System.out.println("😁비밀번호를 입력하세요 >😁");
        String mem_userpw = sc.next();

        StringBuilder sql = new StringBuilder();
        sql.append("select mem_idx from tb_member " +
                        "where mem_userid =? and mem_userpw = ?");
        try{
            Connection conn = Dbconn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, mem_userid);//물음표에 넣기
            pstmt.setString(1, mem_userpw);
            ResultSet rs = pstmt.executeQuery();// sql에서 테이블을 받아오는 것이다. Resultset에 담아짐
          if(rs.next())System.out.println("로그인 되었습니다.");
          else  System.out.println("아이디 비밀번호를 확인하세요");

//            if(rs.next() == rs.wasNull()) {
//                System.out.println("아이디 비밀번호를 확인하세요");
//            }else System.out.println("로그인 되었습니다.");

        }catch (ClassNotFoundException e){//모둘이 올라오지 않는 경우
            e.printStackTrace();
        }catch (SQLException e){// 쿼리가 문제가 나오면
            e.printStackTrace();
        }
    }
}
