package OtherJavaExamples;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yujian on 2017/10/16.
 */
public class Executor_CompletionService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < 10; i++) {
            final int jobid = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    return jobid;
                }
            });
        }
        while (true)
            System.out.println(completionService.take().get());
    }
}
