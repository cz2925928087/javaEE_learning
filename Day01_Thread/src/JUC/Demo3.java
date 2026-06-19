package JUC;

import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    reentrantLock.lock();
                    count ++;
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    reentrantLock.lock();
                    count ++;
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
