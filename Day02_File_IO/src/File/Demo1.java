package File;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./text.txt");
        //getParent得到File对象父目录文件路径
        String parent = file.getParent();
        System.out.println(parent);
        //得到File对象的纯文件名
        String fileName = file.getName();
        System.out.println(fileName);
        //得到File对象的路径
        String path = file.getPath();
        System.out.println(path);
        //得到File对象的绝对路径
        String filePath = file.getAbsolutePath();
        System.out.println(filePath);
        //得到File对象的修饰过的绝对路径
        String canonicalPath = file.getCanonicalPath();
        System.out.println(canonicalPath);
        System.out.println("=================");
        //判断file对象描述的文件是否存在
        boolean isExists = file.exists();
        System.out.println(isExists);
        //判断 File 对象代表的⽂件是否是⼀个⽬录
        boolean fileDirectory = file.isDirectory();
        System.out.println(fileDirectory);
        //判断 File 对象代表的⽂件是否是⼀个普通⽂件
        boolean isFile = file.isFile();
        System.out.println(isFile);
    }
}
