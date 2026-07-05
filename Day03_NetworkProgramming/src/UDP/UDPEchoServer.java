package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//UDP服务器
public class UDPEchoServer {
    private DatagramSocket socket = null;

    //port:端口号
    //服务器需要指定端口号是为了让客户端找到服务器
    public UDPEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    //启动服务器
    public void start() throws IOException {
        System.out.println("Server Start!");

        while (true) {
            /*请求(request):特指客户端给服务器发送的数据
             *响应(response/reply):特指服务器给客户端返回的数据
             * */
            //不停处理客户端发来的请求
            /*1.读取请求并解析,此处的requestPacket是receive的输出参数
            创建DatagramPacket对象,并且分配内存*/
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            //将此处的二进制文件转为字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.根据请求计算响应
            String response = process(request);
            //3.把响应返回给客户端,此处就需要在构建一个DatagramPacket对象
            //requestPacket.getSocketAddress():这个方法作用是得到客户端的IP地址和端口号
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //将响应返回给客户端
            socket.send(responsePacket);

            //打印日志
            System.out.printf("[%s,%d],request:%s,response:%s\n", requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    //根据请求计算回响
    //由于当前的是回响服务器,直接把request作为response返回
    //未来编写其他服务器,只需要改正process当中的逻辑
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UDPEchoServer server = new UDPEchoServer(1024);
        server.start();
    }
}
