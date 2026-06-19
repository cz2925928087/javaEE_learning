package JUC;

import java.util.concurrent.Semaphore;

//使用信号量Semaphore模拟锁
public class Demo5 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
