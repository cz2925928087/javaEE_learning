package UDP;


import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UDPDictServer extends UDPEchoServer{
    private Map<String,String> dictMap = new HashMap<String,String>();

    public UDPDictServer(int port) throws SocketException {
        super(port);
        dictMap.put("pig","新之助");
        dictMap.put("dog","天份");
        dictMap.put("apple","苹果");
    }

    @Override
    public String process(String request) {
        return dictMap.getOrDefault(request,"没有找到");
    }

    public static void main(String[] args) throws IOException {
        UDPDictServer dictServer = new UDPDictServer(1024);
        dictServer.start();
    }
}
