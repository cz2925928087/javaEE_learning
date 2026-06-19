package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        //schedule(TimerTask task,long delay);
        //时间参数delay:延迟多久,不是时间戳
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        },1000);

        Thread.sleep(4000);
        timer.cancel();
    }
}
