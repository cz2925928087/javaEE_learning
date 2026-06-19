package Queue;

import static java.lang.Thread.sleep;

class MyBlockingQueue {
    private Long[] date;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private static Object locker = new Object();

    public MyBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive.");
        }
        date = new Long[capacity];
    }

    public void put(long ele) throws InterruptedException {
        synchronized (locker) {
            while (size == date.length) {
                //队列满了阻塞
                locker.wait();
            }
            //将新的元素放在tail下标上;
            date[tail] = ele;
            tail++;
            if (tail >= date.length) {
                tail = 0;
            }
            //tail = (tail + 1) % date.length;
            size++;
            locker.notify();
        }
    }

    public Long take() throws InterruptedException {
        synchronized (locker) {
            while (size == 0) {
                //队列空了阻塞;
                locker.wait();
            }
            //取出head的元素
            Long ret = date[head];
            head++;
            if (head >= date.length) {
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
        Thread t1 = new Thread(() -> {
            long n = 0;
            while (true) {
                try {
                    myBlockingQueue.put(n);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("生产了: " + n);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                n++;
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费了 " + myBlockingQueue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
