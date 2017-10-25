package OtherJavaExamples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujian on 2017/10/11.
 * 堆内存溢出
 */
class Person{}

public class HeapOutOfMemory {
    public static void main(String[] args){
        int count = 0;
        List<Person> persons = new ArrayList<Person>();
        while(true){
            persons.add(new Person());
            System.out.println("instance:"+(++count));
        }
    }
}
