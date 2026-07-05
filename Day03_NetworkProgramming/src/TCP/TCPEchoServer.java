package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPEchoServer {
    private ServerSocket server = null;

    public TCPEchoServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    public void start() throws IOException{
        System.out.println("server start!");
        //不能使用FixedThreadPool,因为这个线程数是固定的
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            //1.首先接受客户端连接,然后才能进行通信
            //如果有客户端和服务器建立好连接,accept才能够返回
            //否则accept就会阻塞
            //socket本质上是一个文件
            //每有一个客户端连接上服务器就会触发一次accept,都会创建一个socket,他的生命周期只跟随一个连接,但是因为客户端一旦很多,连接就很多,所以就需要将socket关闭
            Socket socket = server.accept();
            //2.处理客户端整个连接过程
            //在处理多个客户端和服务器之间的问题
            //如果直接调用processConnection,就会造成"顾此失彼"的问题,一旦进入processConnection内部
            //就不能再次调用accept
            //processConnection(socket);
            //解决办法:多线程
            //创造新线程,在新线程中调用processConnection
//            Thread thread = new Thread(() -> {
//                try {
//                    processConnection(socket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//            thread.start();
            //如果线程进一步增多,线程的创建和销毁进一步频繁,此时线程创建开销就不可能忽视
            //可以使用线程池进行改进
            executorService.submit(()->{
                try {
                    processConnection(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    // 处理连接
    private void processConnection(Socket socket) throws IOException {
        //在一次连接中,客户端和服务器可能会进行多组数据传输
        System.out.printf("[%s:%d] 客户端已上线!\n",socket.getInetAddress(),socket.getPort());
        //TCP面向字节流
        try(InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream()){
            //Scanner帮忙做了数据解析校验的工作
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                //处理多次请求响应读写
                //一次循环就是读写一次响应/请求
                //1.读取请求并解析(可以直接使用Scanner完成)
                /*byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                String request = new String(bytes,0,n);*/
                if(!scanner.hasNext()){
                    //客户端关闭连接
                    System.out.printf("[%s:%d] 客户端已下线!\n",socket.getInetAddress(),socket.getPort());
                    break;
                }
                String request = scanner.next();
                //2.根据请求计算响应
                String response  = process(request);
                //3.把响应写回客户端
                writer.println(response);
                writer.flush();
                //4.打印日志
                System.out.printf("[%s %d] req:%s resp:%s\n",socket.getInetAddress(),socket.getPort(),request,response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException  {
        TCPEchoServer echoServer = new TCPEchoServer(1025);
        echoServer.start();
    }
}
