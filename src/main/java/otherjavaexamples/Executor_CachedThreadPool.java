package otherjavaexamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yujian on 2017/10/16.
 */
public class Executor_CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i < 4; i++) {
            final int jobid = i;
            TimeUnit.SECONDS.sleep(1);
            executorService.execute(
                    ()->System.out.println("current thread:"+Thread.currentThread().getName()+" current jod:"+jobid));
//            executorService.execute(new Runnable() {
//                public void run() {
//                    System.out.println("current thread:"+Thread.currentThread().getName()+" current jod:"+jobid);
//                }
//            });
        }
    }
}
