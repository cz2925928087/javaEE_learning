package JUC;

import java.util.concurrent.Semaphore;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        System.out.println("进行P操作");
        semaphore.acquire();
        System.out.println("进行P操作");
        semaphore.acquire();
        System.out.println("进行P操作");
        semaphore.acquire();
        System.out.println("进行P操作");


        semaphore.release();
        System.out.println("进行V操作");
        semaphore.acquire();
        System.out.println("进行P操作");
    }

}
