package Thread;

import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread cur = Thread.currentThread();
            while (!cur.isInterrupted()) {
                System.out.println("hello");
                try {
                    Thread.sleep(100_000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    //e.printStackTrace();
                    break;
                }
            }
        });

        Scanner sc = new Scanner(System.in);
        t.start();
        System.out.println("输入一个数0 t线程结束");
        int n = sc.nextInt();
        if (n == 0) {
            t.interrupt();
        }
    }
}
