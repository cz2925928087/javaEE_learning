package MiniProgramPractice;

import java.io.File;
import java.util.Scanner;

/*扫描指定⽬录，并找到名称中包含指定字符的所有普通⽂件（不包含⽬录），
  并且后续询问⽤⼾是否
  要删除该⽂件*/
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.请输入文件路径
        System.out.println("请输入扫描文件的路径");
        String FilePath= scanner.next();
        //2.用户输入路径关键字
        System.out.println("输入文要扫描文件名的关键字");
        String word = scanner.next();
        //3.验证用户输入是否正确
        if(word.isEmpty()) {
            System.out.println("输入的关键字为空");
            return;
        }
        File rootFile = new File(FilePath);
        if(!rootFile.isDirectory()) {
            System.out.println("路径输入有误!");
            return;
        }
        //4.进行搜索
        search(rootFile,word);

    }

    private static void search(File file,String word) {
        //1.列出文件内容
        File[] files = file.listFiles();
        if(files == null) {
            //文件为空,
            return;
        }
        for(File f : files) {
            //判断当前file是否为文件
            if(f.isFile()) {
                //判断当前文件是否包含word关键字
                tryDelete(f,word);
            } else if (f.isDirectory()) {
                //判断是否是目录.如果是目录的话对子目录进行递归查询
                search(f,word);
            } else {
                //正常走不到这里
            }
        }

    }

    private static void tryDelete(File f, String word) {
       Scanner scanner = new Scanner(System.in);
       if(f.getName().contains(word)) {
           System.out.println("找到文件"+f.getAbsolutePath());
           System.out.println("是否需要删除文件Y/N");
           String choice = scanner.next();
           if(choice.equals("Y") || choice.equals("y")) {
               if(f.delete()){
                   System.out.println("删除成功");
               }else {
                   System.out.println("删除失败");
               }

           }else {
               System.out.println("取消删除");
           }
       }
    }
}
