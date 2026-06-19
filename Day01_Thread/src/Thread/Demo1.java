package Thread;

//创建一个类,让这个类继承标准库的Thread类
class Mythread extends Thread {
    //重写父类的run方法
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
            try {
                //休息1000ms==1s;
                //sleep是Thread的一个静态方法
                //sleep作用,让当前线程进入到一个堵塞状态
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        //创建Thread实例
        Thread t = new Mythread();
        /*调用start方法启动线程:
        调用操作系统底层的api,
        在操作系统内部中把线程创建出来,
        然后由操作系统的线程去调用上的run方法
        */
        t.start();
        while (true) {
            System.out.println("world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
