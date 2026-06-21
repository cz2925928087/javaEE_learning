package IOStream.ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//写操作
public class Demo2 {
    public static void main(String[] args) {
        //OutputStream 在默认情况下打开文件会先清空文件内容
        try(OutputStream outputStream = new FileOutputStream("d:/text.txt")) {
            outputStream.write(65);
            outputStream.write(66);
            outputStream.write(67);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        //可以在构造方法的后面加个true这个参数,可以不清空文件内容,追加的内容会跟在末尾
        try(OutputStream outputStream = new FileOutputStream("d:/text.txt",true)) {
            outputStream.write(65);
            outputStream.write(66);
            outputStream.write(67);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("d:/tetx.txt",true)) {
            byte[] bytes = {65,66,67};
            outputStream.write(bytes);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
