import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        System.out.println("서버가 실행되었습니다.");

        ServerSocket serverSocket = null;
        Socket socket = null;

        try{// 프로그램이 지정하는 포트번호를 알아야 한다. 동일한 포트번호가 있으면 충돌이 일어나 작동을 하지 않는다.
            serverSocket = new ServerSocket(3579);//클라이언트가 아이피 주소와 포트번호까지 써줘야 이 문장으로 들어올 수 있다.
            System.out.println("서버가 준비되었습니다.");
            socket = serverSocket.accept(); // 서버가 사용자가 들어올 때까지 대기하고 있는 장소로 들어오면 일반 소켓을 만들어지게 된다.
            System.out.println("클라이언트가 접속되었습니다.");

        }catch (IOException e){
            e.printStackTrace();
        }finally {// 포트가 열려있으면 그 포트는 사용불가하기 때문에
            if(socket != null) try{socket.close();}catch (IOException e){}
            if(serverSocket != null) try{serverSocket.close();}catch (IOException e){}
        }
        System.out.println("프로그램이 종료되었습니다.");
    }
}
