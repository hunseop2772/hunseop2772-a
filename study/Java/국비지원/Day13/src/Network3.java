import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Network3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.koreaisacademy.com/");
            URLConnection conn = url.openConnection();

            System.out.println(conn);
            //sun.net.www.protocol.https.DelegateHttpsURLConnection:https://www.koreaisacademy.com/
            // 데이터를 보여줌
            System.out.println(conn.getContent());
            //sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@be35cd9
            System.out.println(conn.getDate());// 1666142580000 -> timestamp를 알 수 있다. 접속시간 확인
            System.out.println(conn.getURL());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
