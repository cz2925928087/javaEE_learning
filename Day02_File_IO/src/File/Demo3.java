package File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/LearnJAVA/Java-EE_Learning/javaEE_learning/Day02_File_IO");
        //File对象代表的⽬录下的所有⽂件名
        String[] fList = file.list();
        System.out.println(Arrays.toString(fList));
        //返回 File 对象代表的⽬录下的所有⽂件，以 File 对象表⽰
        File[] files = file.listFiles();
        for(File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
}
