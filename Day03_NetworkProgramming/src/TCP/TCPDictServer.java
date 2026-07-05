package TCP;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TCPDictServer extends TCPEchoServer{

    Map<String,String> dict = new HashMap<String,String>();
    public TCPDictServer(int port) throws IOException {
        super(port);
        dict.put("hello","你好");
        dict.put("world","世界");
        dict.put("miss","想念");
        dict.put("like","喜欢");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"没有找到该单词!");
    }

    public static void main(String[] args) throws IOException{
        TCPDictServer dictServer = new TCPDictServer(1025);
        dictServer.start();
    }
}
