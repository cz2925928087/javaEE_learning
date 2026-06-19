package Thread;

//查看线程状态
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainCur = Thread.currentThread();
        Thread t = new Thread(() -> {
            while (true){
                System.out.println("mainCur: " + mainCur.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        t.join(1000000);
        System.out.println(t.getState());
    }

}
