import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Network5 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String url = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
        // 이미지 주소 복사

        try {
            URLConnection conn = new URL(url).openConnection();
            // 이미지에 대한 객체를 가저와서 연결할 수 있게
            bis = new BufferedInputStream(conn.getInputStream());
            // 내가 유얼엘에 저장한것을 스트림으로 저장하여 버퍼에 담는다.
            bos = new BufferedOutputStream(new FileOutputStream("./daum.jpg"));
            // 버퍼에서 내보낸다 파일형태로

            int data =0;
            while((data = bis.read()) != -1){ // -1 끝이 날땍까지
                bos.write(data);
            }
            System.out.println("파일 생성완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(bis != null)
                try{
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            if(bos != null)
                try{
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
        }


    }
}
