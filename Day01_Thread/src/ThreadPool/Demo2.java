package ThreadPool;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//固定数目的线程池
class MyThreadPool {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            //将线程设置为守护线程
            t.setDaemon(true);
            t.start();
        }
    }

    //向线程当中提交任务
    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}


public class Demo2 {
    public static void main1(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    Thread cur = Thread.currentThread();
                    System.out.println(cur.getName() + "," + id);
                }
            });
        }
        //Thread.sleep(1000);
    }
}

