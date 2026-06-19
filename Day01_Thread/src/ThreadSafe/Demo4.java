package ThreadSafe;

public class Demo4 {
    private static void sleep(int min) {
        try {
            Thread.sleep(min);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Object l1 = new Object();
        Object l2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (l1) {
                System.out.println("线程t1获取到锁l1");
                sleep(1000);
            }
            synchronized (l2) {
                System.out.println("线程t1获取到锁l2");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (l2) {
                System.out.println("线程t2获取到锁l2");
                sleep(1000);
            }
            synchronized (l1) {
                System.out.println("线程t2获取到锁l1");
            }
        });
        t1.start();
        t2.start();
    }
}
