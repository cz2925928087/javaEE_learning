package File;

import java.io.File;

public class Demo4 {
    public static void main1(String[] args) {
        File file = new File("./91com");
        System.out.println(file.isDirectory());
        //创建单级目录(文件夹)
        file.mkdir();
        System.out.println(file.isDirectory());
    }

    public static void main(String[] args) {
        File f = new File("./www/91/com");
        System.out.println(f.isDirectory());
        f.mkdirs();
        System.out.println(f.isDirectory()  );
    }
}
