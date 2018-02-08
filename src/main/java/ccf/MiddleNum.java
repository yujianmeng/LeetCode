package ccf;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by yujian on 2017/11/7.
 * 问题描述
 　　在一个整数序列a1, a2, …, an中，如果存在某个数，大于它的整数数量等于小于它的整数数量，则称其为中间数。在一个序列中，可能存在多个下标不相同的中间数，这些中间数的值是相同的。
 　　给定一个整数序列，请找出这个整数序列的中间数的值。
 输入格式
 　　输入的第一行包含了一个整数n，表示整数序列中数的个数。
 　　第二行包含n个正整数，依次表示a1, a2, …, an。
 输出格式
 　　如果约定序列的中间数存在，则输出中间数的值，否则输出-1表示不存在中间数。
 样例输入
 6
 2 6 5 6 3 5
 样例输出
 5
 样例说明
 　　比5小的数有2个，比5大的数也有2个。
 样例输入
 4
 3 4 6 7
 样例输出
 -1
 样例说明
 　　在序列中的4个数都不满足中间数的定义。
 样例输入
 5
 3 4 6 6 7
 样例输出
 -1
 样例说明
 　　在序列中的5个数都不满足中间数的定义。
 评测用例规模与约定
 　　对于所有评测用例，1 ≤ n ≤ 1000，1 ≤ ai ≤ 1000。
 */
public class MiddleNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> nums = new Vector<>();
        int n = scanner.nextInt();
        int i=0;
        while (i<n){
            nums.add(scanner.nextInt());
            i++;
        }
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return 1;
                }else if(o1<o2){
                    return -1;
                }
                else {return 0;}
            }
        });
        int mi = nums.get(nums.size()/2);
        int small = 0;
        int bigger = 0;
        for (int t:nums){
            if (t<mi){
                small++;
            }
            if (t>mi){
                bigger++;
            }
        }
        if (small==bigger){
            System.out.println(mi);
        }else {
            System.out.println(-1);
        }
    }
}
