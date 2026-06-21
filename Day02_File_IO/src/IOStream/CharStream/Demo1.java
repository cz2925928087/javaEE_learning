package IOStream.CharStream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("d:/text.txt")) {
//            while(true) {
//                int n = reader.read();
//                if(n==-1) {
//                    break;
//                }
//                char c = (char)n;
//                System.out.println(c);
//            }
            while(true) {
                char[] c = new char[1024];
                int n = reader.read(c);
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(c[i]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
