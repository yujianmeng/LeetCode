package otherjavaexamples;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Created by yujian on 2017/10/11.
 * 本地内存溢出
 */
public class DirectMemoryOutOfMemory {
    private static final int ONE_GB = 1024*1024*1024;

    public static void main(String[] args) {
        int counter = 0;
        try{
            while (true){
                Buffer buffer = ByteBuffer.allocateDirect(ONE_GB);
                counter++;
            }
        }catch (Exception e){
            System.out.println("Exception:instance created:"+counter);
            e.printStackTrace();
        }catch (Error e){
            System.out.println("Error:instance created:"+counter);
            e.printStackTrace();
        }
    }
}
