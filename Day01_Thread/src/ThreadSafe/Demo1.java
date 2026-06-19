package ThreadSafe;

public class Demo1 {
    private static int count = 0;
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread mainCur = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            //加锁要对同一个对象进行加锁,不然起不到线程安全的作用
            synchronized (obj) {
                for (int i = 0; i < 5000; i++) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 5000; i++) {
                    count++;
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
