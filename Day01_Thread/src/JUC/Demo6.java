package JUC;
import java.util.concurrent.CountDownLatch;
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        //初始化8表示有8个任务需要完成
        CountDownLatch countDownLatch = new CountDownLatch(8);
        for (int i = 0; i < 8; i++) {
            int id = i;
            Thread  thread = new Thread(()->{
                System.out.println("运动员"+id+"开始");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("运动员"+id+"到达终点");
                //"撞线操作",计数器countDownLatch中保存的值-1
                countDownLatch.countDown();
            });
            thread.start();
        }
        //主线程中如何判定运动员都到达终点
        //通过await进行等待,等待过程中,会把当前线程进行阻塞
        countDownLatch.await();
        System.out.println("比赛结束");

    }
}
