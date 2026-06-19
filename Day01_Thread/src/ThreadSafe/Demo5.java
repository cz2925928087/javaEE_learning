package ThreadSafe;

import java.util.Scanner;

public class Demo5 {
    private static volatile int flg = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            while (flg == 0) {};
            System.out.println("t1结束");
        },"线程A");
        Thread t2 = new Thread(()->{
            System.out.println("输入一个数");
            Scanner sc = new Scanner(System.in);
            flg = sc.nextInt();
            System.out.println("t2结束");
        },"线程B");
        t1.start();
        t2.start();
    }
}
