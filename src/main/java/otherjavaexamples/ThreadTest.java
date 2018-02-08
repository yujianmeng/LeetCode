package otherjavaexamples;

/**
 * Created by yujian on 2017/11/1.
 */
public class ThreadTest implements Runnable{

    private static Integer m = 1000;
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        for (int i = 0; i < 10; i++) {
            new Thread(threadTest).start();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (m > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + m);
                m--;
            }
        }
    }
}
