package Thread;

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           while (true) {
               System.out.println("hello 1");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        thread.start();
        while (true) {
            System.out.println(2);
            Thread.sleep(1000);
        }
    }
}
