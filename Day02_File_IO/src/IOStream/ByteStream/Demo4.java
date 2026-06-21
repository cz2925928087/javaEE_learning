package IOStream.ByteStream;

import java.io.IOException;
import java.io.PrintWriter;

public class Demo4 {
    public static void main(String[] args) {
        try(PrintWriter printWriter = new PrintWriter("d:/text.txt" )) {
            printWriter.printf("I miss you");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
