package Design;

//懒汉模式线程安全问题
class SingletonLazyThreadSafe {
    private int x = 100;
    private int y = 200;
    public void func() {
        System.out.println(x+y);
    }
    //volatile 避免指令重排序引起的问题
    private static volatile SingletonLazyThreadSafe instance = null;

    public static SingletonLazyThreadSafe getInstance() {
        //判断if是否需要加锁
        if (instance == null) {
            synchronized (SingletonLazyThreadSafe.class) {
                //判断是否需要创建实例
                if (instance == null) {
                    instance = new SingletonLazyThreadSafe();
                }
            }
        }
        return instance;
    }

    private SingletonLazyThreadSafe() {
    }
}

public class Demo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            SingletonLazyThreadSafe s1 = SingletonLazyThreadSafe.getInstance();
            s1.func();
        }, "t1");

        Thread t2 = new Thread(() -> {
            SingletonLazyThreadSafe s2 = SingletonLazyThreadSafe.getInstance();
            System.out.println(s2.toString());
        }, "t2");
        t1.start();
        t2.start();
    }
}
