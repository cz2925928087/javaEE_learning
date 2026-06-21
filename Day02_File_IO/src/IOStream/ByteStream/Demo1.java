package IOStream.ByteStream;
//读操作
import java.io.*;


public class Demo1 {
    public static void main1(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("d:/text.txt");
        //创建流对象的过程,相当于打开"文件";
        //打开后就可以进行读操作,(InputStream只能读,OutputStream只能写)
        //使用read进行读
        /*while(true) {
            int n = inputStream.read();
            if(n == -1) {
                //如果n==-1就代表读到了文件末尾,读取完毕
                break;
            }
            //打印字节,一般是十六进制
            System.out.printf("%x\n",n);
        }*/
        while (true) {
            byte[] bytes = new byte[1024];
            int n = inputStream.read(bytes);
            if (n == -1) {
                break;
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%x\n", bytes[i]);
            }
        }

        inputStream.close();
    }


    public static void main2(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("d:/text.txt");
            while (true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                if (n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%x\n", bytes[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //使用try with resource 语法,这个代码会在try执行完毕自动调用close()
    //try() 当中定义的对象需要实现 Closeable接口,在这个接口当中有个close的方法,所以当执行完,会自动释放
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("d:/text.txt")) {
            while(true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%x\n",bytes[i]);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
