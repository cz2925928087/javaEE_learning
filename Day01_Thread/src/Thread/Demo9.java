package Thread;

public class Demo9 {
    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        //创建一个新线程,在这个线程中计算1+2+3+....+1000;
        //主线程在这个线程执行完毕之后,打印此处的结果
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            System.out.println("t线程执行完毕");
        });
        t.start();
        //join等待t线程结束
        t.join();
        //Thread.sleep(10000);
        System.out.println(sum);
    }


}
