package otherjavaexamples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yujian on 2017/10/16.
 */
public class Executor_ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("heart beat! peng...peng...peng......");
            }
        };
        //5秒后第一次执行，之后每隔3秒执行一次
        executor.scheduleAtFixedRate(task,5,3, TimeUnit.SECONDS);
    }
}
