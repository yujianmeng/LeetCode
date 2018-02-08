package facetime;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yujian on 2018/1/24.
 * 有一个自然数集合，其中最小的数是1，最大的数是100。
 * 这个集合中的数除了1之外，每个数都可由集合中的某两个数相加而得（这两个数可以相同）。
 * 利用回溯法编写程序，求符合上述条件的、元素个数为10的所有集合。
 */
public class TenNumber {
    private static int n = 0;
    private static List<Integer> nums = new LinkedList<>();
    private static List<Integer> tmpNums = new LinkedList<>();
    private static List<List<Integer>> numLists = new LinkedList<>();
    public static void main(String[] args) {
        nums.add(1);
        trial(2,2);
        int j = 1;
        for (List l:numLists){
            System.out.print("case "+j+++": ");
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println();
        }
    }

    private static void trial(int i, int k){
        if (i>9){
            nums.add(100);
            if (isOk(100)) {
                tmpNums = new LinkedList<>(nums);
                numLists.add(tmpNums);
            }
            nums.remove(nums.size()-1);
        }
        else {
            for (int j = k; j <= 99; j++) {
                if (j>2*(nums.get(nums.size()-1))){
                    break;
                }
                nums.add(j);
                if (isOk(j)){
                    trial(i+1,j+1);
                }
                nums.remove(nums.size()-1);
            }
        }
    }

    private static boolean isOk(int j){
        for (int i = 0; i < nums.size(); i++) {
            if (nums.contains(j-nums.get(i))){
                return true;
            }
        }
        return false;
    }
}
