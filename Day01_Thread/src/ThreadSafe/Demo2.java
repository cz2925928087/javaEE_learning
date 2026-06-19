package ThreadSafe;

class Counter {
    public int count = 0;
    //把synchronized锁加到实例方法上,就是给this加锁;
    synchronized public void add() {
            count++;
    }
    /*上面写法等价于
    * public void add() {
    *   synchronized(this) {
    *       count++;
    *   }
    * }
    * */
}
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                c.add();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                c.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);
    }
}
