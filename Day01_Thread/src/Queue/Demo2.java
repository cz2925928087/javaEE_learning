package Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/*生产者消费模型
* 一个线程表示生产者
* 一个线程表示消费者
* 搞一个阻塞队列,生产者往阻塞队列放一个整数,消费者进行获取
* */
class BlockingQu {
    private static BlockingQueue<Long> blockingQueue = null;

    public static BlockingQueue<Long> getBlockingQueue() {
        if(blockingQueue == null) {
            synchronized (BlockingQu.class) {
                if(blockingQueue == null) {
                    blockingQueue = new ArrayBlockingQueue<>(100);
                }
            }
        }
        return blockingQueue;
    }

    private BlockingQu() {}
}

public class Demo2 {
    private static void put(Long n) {
        try {
            BlockingQu.getBlockingQueue().put(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static long take() {
        long n;
        try {
            n = BlockingQu.getBlockingQueue().take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n;
    }
    public static void main(String[] args) {
        //t1线程表示生产者
        Thread t1 = new Thread(()->{
            long n = 0;
            while(true) {
                put(n);
                System.out.println("生产了: "+n);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                n++;
            }
        },"Producer");

        //t2线程表示消费者
        Thread t2 = new Thread(()->{
            while(true) {
                System.out.println("消费了 "+take());
            }
        },"Consumer");

        t1.start();
        t2.start();
    }
}
