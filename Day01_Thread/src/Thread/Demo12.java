package Thread;

import java.util.Scanner;

public class Demo12 {
    private static Object object = new Object();

    public static void Wait() {
        try {
            object.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t1 wait 之前");
                Wait();
                System.out.println("t1 wait 之后");
            }
        }, "t1线程");
        Thread t2 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t2 wait 之前");
                Wait();
                System.out.println("t2 wait 之后");
            }
        }, "t2线程");
        Thread t3 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t3 wait 之前");
                Wait();
                System.out.println("t3 wait 之后");
            }
        }, "t3线程");
        Thread t4 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t4 wait 之前");
                Wait();
                System.out.println("t4 wait 之后");
            }
        }, "t4线程");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread t5 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t5 notify 之前");
                object.notify();
                Scanner sc = new Scanner(System.in);
                sc.next();
                System.out.println("t5 notify 之后");
            }
        }, "t5线程");
        t5.start();
    }
}
