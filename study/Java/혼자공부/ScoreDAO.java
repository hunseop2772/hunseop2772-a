import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDAO {





    public  String list() throws ClassNotFoundException, SQLException {
        Connection conn = DBcon.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("select st_id, st_name, st_hp, st_gender, st_address,st_rdate from tb_student order by st_id");
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        String s = "";

        while (rs.next()) {
            String st_id = rs.getString("st_id");
            String st_name = rs.getString("st_name");
            String st_hp = rs.getString("st_hp");
            String st_gender = rs.getString("st_gender");
            String st_address = rs.getString("st_address");
            String st_rdate = rs.getString("st_rdate");
            s += st_id + ": " + st_name +  ": " + st_hp +
                    ": " + st_gender +  ": "+st_address+": "+st_rdate+"\n";
        }
        return s;
    }

    public  String scoreList() throws ClassNotFoundException, SQLException{
        Connection conn = DBcon.getConnection();
        StringBuilder sql = new StringBuilder();
        System.out.println("성적보기");
        sql.append("select st_id, st_name, sc_kor,sc_math,sc_eng,sc_avg,sc_sum  \n" +
                " from tb_student left join tb_score on tb_student.st_id = tb_score.sc_id;");
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        String l = "";
        while (rs.next()) {
            String st_id = rs.getString("st_id");
            String st_name = rs.getString("st_name");
            int sc_kor = rs.getInt("sc_kor");
            int sc_math = rs.getInt("sc_math");
            int sc_eng = rs.getInt("sc_eng");
            int sc_avg = rs.getInt("sc_avg");
            int sc_sum = rs.getInt("sc_sum");
            l +=" 아이디 : "+st_id + " 이름 : " + st_name +  " 국어 : " + sc_kor +
                    "수학 : " + sc_math +  "영어 : "+sc_eng+" 평균 : "+sc_avg+" 합계: "+sc_sum + "\n";
        }
        return l;
    }

}
