import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {
        System.out.println("클라이언트가 실행되었습니다.");
        Socket socket = null;
        BufferedReader br = null;//받을거기 때문에
        BufferedWriter bw = null;

        try{
            System.out.println("서버와 연결을 시도중입니다");
            socket = new Socket("192.168.6.13",3579);//접속이 잘되면 소켓생성
            System.out.println("연결되었습니다");
            br = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("메시지를 입력하세요");
            Scanner sc = new Scanner(System.in);
            String msg = sc.next();
            bw.write(msg+"\n");
            bw.flush();
            System.out.println("전소되었습니다.");

            String msg2 = br.readLine();
            System.out.println("서버메세지 : "+msg2);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(br != null) try{br.close();}catch(IOException e){}
            if(socket != null) try{socket.close();} catch (IOException e){}
        }
        System.out.println("프로그램이 종료되었습니다");
    }
}


