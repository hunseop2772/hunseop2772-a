import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network1 {
    public static void main(String[] args) {
        try {
//            InetAddress inetAddress = InetAddress.getByName("www.naver.com");
//              도메인 내임을 겟 네임에 주면 아이피 어드레스를 얻을 수 있다/}
//            System.out.println(inetAddress.getHostName());
//              도메인을 츨력한다. www.naver.com
//            System.out.println(inetAddress.getHostAddress());
//              IP주소 223.130.200.107

            InetAddress[] inetAddress = InetAddress.getAllByName("www.naver.com");
            // 배열로 모든 도메인 네임에 있는 아이피 어드레스를 가저온다
     for(InetAddress iAdd : inetAddress){
         System.out.println(iAdd.getHostAddress());
         // 공개 IP 전부 찍힘 223.130.195.200
                          //223.130.195.95
     }
        } catch (UnknownHostException e) {//강제
            e.printStackTrace();
        }
    }
}