package JUC;
//不使用Callable
class Result {
    public int sum = 0;
    public Object lock = new Object();
}


public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        Thread thread = new Thread(()->{
            int sum = 0;
            for (int i = 0; i <= 1000 ; i++) {
                sum += i;
            }
            synchronized (result.lock) {
                result.sum = sum;
                result.lock.notify();
            }
        });
        thread.start();
        synchronized (result.lock) {
            while(result.sum == 0) {
                result.lock.wait();
            }
            System.out.println(result.sum)                     ;
        }
    }
}
