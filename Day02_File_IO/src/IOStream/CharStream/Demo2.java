package IOStream.CharStream;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("d:/text.txt")) {
            writer.write("你好!世界");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
