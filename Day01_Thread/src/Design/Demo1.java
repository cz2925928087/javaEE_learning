package Design;

class SingletonHungry {
    //加了static 当前的成员就成了类属性,在类对象上的,类对象只能有一个实例
    //此处的instance保证了在当前Java进程当中只有一份
    //饿汉模式.会在类加载的时候创建实例
    //类加载:.java=>.class=>被JVM加载到内存,得到类对象
    private final static SingletonHungry instance = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return instance;
    }

    //单例模式最关键的要点,禁止构造方法被外部使用
    private SingletonHungry() {
    }
}

public class Demo1 {
    public static void main(String[] args) {
        SingletonHungry s1 = SingletonHungry.getInstance();
        SingletonHungry s2 = SingletonHungry.getInstance();
        System.out.println(s1==s2);

    }
}
