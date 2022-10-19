import java.net.MalformedURLException;
import java.net.URL;

public class Network2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=c4i&oquery=" +
                    "%EB%82%B4+ip&tqi=h09aCsprvxZssLrqXLwssssssB8-375298");

            System.out.println(url.getProtocol());// 프로토콜을 출력 https:와 같은것
            System.out.println(url.getHost()); // 호스트(도메인)
            System.out.println(url.getPort()); // 기본값 -1(80)
            System.out.println(url.getPath()); // https 같은것(도메인) 뒤에 나오는 리소스
            System.out.println(url.getQuery()); // 값 (응답) - 내가 보내는(검색) 값을 전달해준다.

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
