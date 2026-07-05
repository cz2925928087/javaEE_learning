import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpClient {
    private Socket socket;
    private String ip;
    private int port;

    public HttpClient(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip, port);
    }

    public String get(String url) throws IOException {
        StringBuilder request = new StringBuilder();
        // 构造⾸⾏
        request.append("GET " + url + " HTTP/1.1\n");
        // 构造 header
        request.append("Host: " + ip + ":" + port + "\n");
        // 构造 空⾏
        request.append("\n");
        // 发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(request.toString().getBytes());
        // 读取响应数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        int n = inputStream.read(buffer);
        return new String(buffer, 0, n, "utf-8");
    }

    public String post(String url, String body) throws IOException {
        StringBuilder request = new StringBuilder();
        // 构造⾸⾏
        request.append("POST " + url + " HTTP/1.1\n");
        // 构造 header
        request.append("Host: " + ip + ":" + port + "\n");
        request.append("Content-Length: " + body.getBytes().length + "\n");
        // 构造 空⾏
        request.append("\n");
        // 构造 body
        request.append(body);
        // 发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(request.toString().getBytes());
        // 读取响应数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        int n = inputStream.read(buffer);
        return new String(buffer, 0, n, "utf-8");
    }

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new HttpClient("42.192.83.143", 8080);
        String getResp = httpClient.get("/AjaxMockServer/info");
        System.out.println(getResp);
        String postResp = httpClient.post("/AjaxMockServer/info", "this is body");
        System.out.println(postResp);
    }

}
