package IOStream.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("d:/text.txt")) {
            Scanner sc =new Scanner(inputStream);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(a+","+b+","+c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
