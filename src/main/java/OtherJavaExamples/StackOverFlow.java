package OtherJavaExamples;

/**
 * Created by yujian on 2017/10/11.
 * 栈溢出
 */
public class StackOverFlow {

    private int counter;
    public void conut(){
        counter++;
        conut();
    }
    public static void main(String[] args){
        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.conut();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
