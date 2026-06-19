package Queue;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        //基于数组
        BlockingQueue<String> blockingQueue1 =new ArrayBlockingQueue<>(100);
        //基于链表
        //BlockingQueue<String> blockingQueue2 = new LinkedBlockingDeque<>();
        //基于堆
        //BlockingQueue<String> blockingQueue3 = new PriorityBlockingQueue<>();

        //BlockQueue继承Queue 所以也继承了Queue的方法(add,offer,poll),但是这些方法不会产生阻塞效果
        //所以使用阻塞队列一般使用put和take,这两个方法产生阻塞,put入,take出;
        //入队列
        blockingQueue1.put("xj");
        //出队列
        String ele = blockingQueue1.take();
        System.out.println(ele);
    }
}
