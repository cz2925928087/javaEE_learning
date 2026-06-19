package Timer;

import java.util.PriorityQueue;
//创建认为类,表示定时器要执行的任务
class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;
    //任务在何时被执行,time填写ms级时间戳
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    //获取到任务在何时被执行
    public long getTime() {
        return time;
    }

    //执行任务
    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }
}

//自定义Timer类
class MyTimer {
    //通过集合类把多个安排的任务给保存起来
    PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    //创建锁对象
    Object locker = new Object();

    public MyTimer() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        if (queue.isEmpty()) {
                            //使用wait避免忙等
                            locker.wait();
                        }
                        //1.取出队首元素
                        MyTimerTask task = queue.peek();
                        //2.判断时间是否到达
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            //时间到达,执行
                            task.run();
                            queue.poll();
                        } else {
                            //时间没到
                            //wait(....)重新确认时间
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            MyTimerTask task = new MyTimerTask(runnable, delay);
            queue.add(task);
            locker.notify();
        }
    }
}


public class Demo2 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(()->{
            System.out.println("2000");
        },2000);
        timer.schedule(()->{
            System.out.println("3000");
        },3000);
        timer.schedule(()->{
            System.out.println("1000");
        },1000);
    }
}
