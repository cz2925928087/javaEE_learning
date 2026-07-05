package UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

//UDP客户端
public class UDPEchoClient {
    private DatagramSocket socket = null;
    private String ServerIP;
    private int ServerPort;

    //编写客户端程序的时候不能指定端口号,是因为客户端是用户操作,程序员无法知道用户的电脑中其他的进程和是否占用同样的端口号,可能会发生冲突
    //所以在编写客户端程序的时候不能指定端口号,然后不指定端口号,操作系统会自动分配空闲的端口号
    public UDPEchoClient(String ServerIP, int ServerPort) throws SocketException {
        //五元组确定:
        /*协议类型:UDP
         * 源IP:运行客户端程序的机器IP
         * 源端口:系统分配
         * 目的IP和目的端口:服务器IP和服务器端口
         * */
        this.socket = new DatagramSocket();
        this.ServerIP = ServerIP;
        this.ServerPort = ServerPort;
    }

    public void start() throws IOException {
        System.out.println("Client Start!");
        Scanner scanner = new Scanner(System.in);
        //用户通过控制台输入字符串,把字符串发送给服务器,从服务器中读取响应
        while (true) {
            //1.从控制台读取用户输入
            System.out.print("->");
            String request = scanner.next();
            if (request.equals("exit")) {
                break;
            }
            //2.把用户输入的字符串构造成UDP数据报进行发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.ServerIP),this.ServerPort);
            socket.send(requestPacket);
            //3.从服务器中读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //显示响应
            System.out.println(response);
        }

    }

    public static void main(String[] args) throws IOException {
        UDPEchoClient client = new UDPEchoClient("127.0.0.1", 1024);
        client.start();
    }
}
