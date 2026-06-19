package Thread;

public class Demo13_ThreadLocal {
    //此处的线程级变量就是一个Integer
    //通常ThreadLocal是被static final所修饰
    //为的是确保t1指向的实例是单例的
    //所创建的副本都是通过哈希表进行管理
    private static final ThreadLocal<Integer> tl = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //t1线程可以使用tl中的变量内容
            /*当t1使用tl的时候,就会把tl里包裹的Integer的值,
             * 往t1线程中复制一个副本,t1后续的操作都是针对自己的副本进行
             */
            for (int i = 0; i < 100; i++) {
                tl.set(i);
            }
            System.out.println("t1 " + tl.get());
        });
        Thread t2 = new Thread(() -> {
            //和t1毫无关系,把tl复制一个副本到t2,t2后续的进行都是在副本当中
            for (int i = 0; i < 1000; i++) {
                tl.set(i);
            }
            System.out.println("t2 " + tl.get());
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main" + tl.get());
    }
}
