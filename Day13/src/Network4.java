import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
// buffer 이를 통해 크롤링은 가능하지만 자바로 하는것은 추천하지는 않는다. 파이썬으로 하는게 편하다 크롤링의 경우
public class Network4 {
    public static void main(String[] args) {
        BufferedReader br =null;

        try {
            URL url = new URL("https://www.koreaisacademy.com/");
           // InputStream isr = new InputStreamReader(url.openStream());
            // br = new BufferedReader(isr); 이렇게 해도 괜찮지만 밑에 방식이 더 편하다.
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            // 버퍼리더 임시저장
            //url.openStream() url을 열어 데이터를 가저온다. 스트림을 통해 가저와야하고 인풋스트림이 있어야한다.
            String data = null;
            while((data = br.readLine()) != null ){//읽을게 있으면
                System.out.println(data);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {// 무조건 들림 파이널리는
            {
                if(br != null){ // 버퍼가 존재한다면 없에라
                    try {
                        br.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

