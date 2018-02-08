package ccf;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yujian on 2017/11/6.
 * 问题描述
 　　小葱喜欢除法，所以他给了你N个数a1, a2, ⋯, aN，并且希望你执行M次操作，每次操作可能有以下两种：
 　　给你三个数l, r, v，你需要将al, al+1, ⋯, ar之间所有v的倍数除以v。
 　　给你两个数l, r，你需要回答al + al+1 + ⋯ + ar的值是多少。

 输入格式
 　　第一行两个整数N, M，代表数的个数和操作的次数。
 　　接下来一行N个整数，代表N个数一开始的值。

 输出格式
 　　对于每一次的第二种操作，输出一行代表这次操作所询问的值。
 样例输入

 5 3
 1 2 3 4 5
 2 1 5
 1 1 3 2
 2 1 5
 1
 2
 3
 4
 5
 样例输出

 15
 14
 1
 2
 评测用例规模与约定
 　　对于30%的评测用例，1 ≤ N, M ≤ 1000；
 　　对于另外20%的评测用例，第一种操作中一定有l = r；
 　　对于另外20%的评测用例，第一种操作中一定有l = 1 , r = N；
 　　对于100%的评测用例，1 ≤ N, M ≤ 105，0 ≤ a1, a2, ⋯, aN ≤ 106, 1 ≤ v ≤ 106, 1 ≤ l ≤ r ≤ N。
 */
public class Devide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] arr = new long[n];
        List<Long> result = new LinkedList<>();
        int i=0;
        while (i<n){
            arr[i++]=scanner.nextInt();
        }
        i=0;
        while (i++<m){
            int op = scanner.nextInt();
            if (op == 1){
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                int v = scanner.nextInt();
                int space = 1;
                for (int j = begin; j <= end;) {
                    if (arr[j-1]%v==0){
                        arr[j-1]=arr[j-1]/v;
                        space = v;
                    }
                    j=j+space;
                }
            }else {
                long sum = 0;
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                for (int j = begin; j <= end; j++) {
                    sum+=arr[j-1];
                }
                result.add(sum);
            }
        }
        for (long sum:result){
            System.out.println(sum);
        }
    }
}
