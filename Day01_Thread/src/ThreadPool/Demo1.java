package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        ExecutorService e1 = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 100; i++) {
            int id = i;
            e.submit(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println(name+","+id);
                }
            });
        }
    }
}

