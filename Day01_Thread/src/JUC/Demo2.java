package JUC;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//使用Callable接口
public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable= new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0;i <= 1000;i++) {
                    sum+=i;
                }
                return sum;
            }
        };
        /*
        * 对于Thread 来说,无法直接是用Callable对象作为参数,
        * 而需要搭配FutureTask
        * */
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        //get方法拿到call的返回结果,
        //如果call还没执行完,get就会阻塞等待;
        System.out.println(futureTask.get());
    }
}
