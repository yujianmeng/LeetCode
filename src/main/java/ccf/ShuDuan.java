package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/12/2.
 * 问题描述
 　　给定一个整数数列，数列中连续相同的最长整数序列算成一段，问数列中共有多少段？
 输入格式
 　　输入的第一行包含一个整数n，表示数列中整数的个数。
 　　第二行包含n个整数a1, a2, …, an，表示给定的数列，相邻的整数之间用一个空格分隔。
 输出格式
 　　输出一个整数，表示给定的数列有多个段。
 样例输入
 8
 8 8 8 0 12 12 8 0
 样例输出
 5
 样例说明
 　　8 8 8是第一段，0是第二段，12 12是第三段，倒数第二个整数8是第四段，最后一个0是第五段。
 评测用例规模与约定
 　　1 ≤ n ≤ 1000，0 ≤ ai ≤ 1000。
 */
public class ShuDuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int duan = 1;
        int upper = scanner.nextInt();
        int i=1;
        while (i<n){
            int nowNum = scanner.nextInt();
            if (nowNum!=upper){
                duan++;
                upper = nowNum;
            }
            i++;
        }
        System.out.println(duan);
    }
}
