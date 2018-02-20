package other_java_examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujian on 2017/10/11.
 * 常量池内存溢出
 */
public class ConstantsOutOfMemory {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int counter = 0;
        while (true){
            try {
                list.add(String.valueOf(counter++).intern());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
