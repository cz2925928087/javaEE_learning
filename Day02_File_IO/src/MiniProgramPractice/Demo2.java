package MiniProgramPractice;

import java.io.*;
import java.util.Scanner;
//进⾏普通⽂件的复制
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //让用户输入要复制的文件路径,和要复制的目标路径
        System.out.println("请输入要复制的源文件路径");
        String srcPath = scanner.next();
        System.out.println("请输入要复制到的文件路径");
        String destPath = scanner.next();

        //2.验证用户输入路径是否合法
        File srcfile = new File(srcPath);
        if (!srcfile.isFile()) {
            System.out.println("源文件路径错误!");
            return;
        }
        //3.判定destPath的parent是否存在且是否是目录
        File destfile = new File(destPath);
        File destParent = destfile.getParentFile();
        if (!destParent.isDirectory()) {
            System.out.println("目标文件错误");
            return;
        }

        //复制,把两个文件打开,然后将srcFile的内容复制到destFile里
        try (InputStream inputStream = new FileInputStream(srcfile);
             OutputStream outputStream = new FileOutputStream(destfile)) {
            byte[] bytes = new byte[1024];
            while (true) {
                int n = inputStream.read(bytes);
                if (n == -1) {
                    break;
                }
                outputStream.write(bytes, 0, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("复制完成");
    }
}
