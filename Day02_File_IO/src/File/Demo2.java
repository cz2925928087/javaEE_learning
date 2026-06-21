package File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) throws IOException {
        File file = new File("./text.txt");
        System.out.println(file.exists());
        //新建一个文件
        file.createNewFile();
        System.out.println(file.exists());
        //删除文件
//        file.delete();
//        System.out.println(file.exists());
        //程序进程结束的时候删除
        file.deleteOnExit();
        System.out.println(file.exists());

        //使用scanner对主线程进行阻塞
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
