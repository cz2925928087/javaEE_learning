package Thread;

import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("t1 wait之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 wait之后");
            }
        });
        Thread t2 = new Thread(() -> {
            //notify和wait一样,需要放在synchronized()内部
            synchronized (obj) {
                System.out.println("t2 notify之前");
                Scanner sc = new Scanner(System.in);
                System.out.println("输入一个内容后执行notify");
                sc.next();
                obj.notify();
                System.out.println("t2 notify之后");
            }
        });
        t1.start();
        t2.start();
    }
}
