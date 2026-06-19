package ThreadSafe;

//针对类对象加锁
public class Demo3 {
    public static int count = 0;
    public static void add() {
        synchronized (Demo3.class){
            count++;
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                add();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                add();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
