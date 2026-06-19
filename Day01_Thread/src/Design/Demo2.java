package Design;

class SingletonLazy {
    private static SingletonLazy instance = null;

    //懒汉模式的关键在于把创建实例的时机推迟到第一次使用的时候
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    private SingletonLazy() {

    }
}

public class Demo2 {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2);
    }
}
