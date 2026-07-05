package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {
    private Socket socket = null;
    private String serverIP;
    private int serverPort;

    public TCPEchoClient(String serverIP, int serverPort) throws IOException {
        //客户端在new Socket的时候,就会和服务器建立TCP连接
        //需要服务器IP和端口
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("client start");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter writer = new PrintWriter(outputStream);
            Scanner scannerNetWork = new Scanner(inputStream);
            while (true) {
                //1.从控制台读取用户输入
                System.out.print("->");
                String request = scanner.next();
                //2.把请求发送给服务器
                //writer类当中自带缓冲器,只有当缓冲器满了才会发送请求到服务器
                writer.println(request);
                //flush()方法可以冲刷缓冲器,即使缓冲区没满也能写入
                writer.flush();
                //3.从服务器读取响应
                if(!scannerNetWork.hasNext()) {
                    break;
                }
                String response = scannerNetWork.next();
                //4.把相应显示到控制台上
                System.out.println(response);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        TCPEchoClient echoClient = new TCPEchoClient("127.0.0.1",1025);
        echoClient.start();
    }
}
