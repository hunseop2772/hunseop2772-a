import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    public static void main(String[] args) {
        System.out.println("서버가 실행되었습니다.");

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try{// 프로그램이 지정하는 포트번호를 알아야 한다. 동일한 포트번호가 있으면 충돌이 일어나 작동을 하지 않는다.
            serverSocket = new ServerSocket(3579);//클라이언트가 아이피 주소와 포트번호까지 써줘야 이 문장으로 들어올 수 있다.
            System.out.println("서버가 준비되었습니다.");
            socket = serverSocket.accept(); // 서버가 사용자가 들어올 때까지 대기하고 있는 장소로 들어오면 일반 소켓을 만들어지게 된다.
            System.out.println("클라이언트가 접속되었습니다.");

            br = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 소켓에서 밖으로 보넬것을 만들고 -> 밖으로 보넬 아웃풋 스트림을 통해 나갈거 만들고 -> 버퍼에다 담을거기 떄문에 만든다.

            String dan = br.readLine();
            int intdan = Integer.parseInt(dan);

                    for(int i=1; i<=9; i++){
                        bw.write(intdan + "*"+i+"="+(intdan *i)+"\n");
                    }

            bw.flush();
            System.out.println("전송되었습니다.");

        }catch (IOException e){
            e.printStackTrace();
        }finally {// 포트가 열려있으면 그 포트는 사용불가하기 때문에
            if(br != null) try{br.close();}catch (IOException e){}
            if(bw != null) try{bw.close();}catch (IOException e){}
            if(socket != null) try{socket.close();}catch (IOException e){}
            if(serverSocket != null) try{serverSocket.close();}catch (IOException e){}
        }
        System.out.println("프로그램이 종료되었습니다.");
    }
}

