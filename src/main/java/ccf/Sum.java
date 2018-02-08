package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/12/1.
 * 问题描述
 　　给定一个十进制整数n，输出n的各位数字之和。
 输入格式
 　　输入一个整数n。
 输出格式
 　　输出一个整数，表示答案。
 样例输入
 20151220
 样例输出
 13
 样例说明
 　　20151220的各位数字之和为2+0+1+5+1+2+2+0=13。
 评测用例规模与约定
 　　所有评测用例满足：0 ≤ n ≤ 1000000000。
 */
public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int yu = n/10;
        int sum = 0;
        while (yu>=1){
            sum+=n%10;
            n = yu;
            yu = n/10;
        }
        sum = sum+n;
        System.out.println(sum);
    }
}
