package facetime;

import java.util.Scanner;

/**
 * Created by yujian on 2017/11/30.
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 输入描述:
 输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'


 输出描述:
 输出一个整数,表示最长的满足要求的子串长度。

 输入例子1:
 111101111

 输出例子1:
 3
 */
public class InterleaveNums {
    private static char[] s;
    private static int tmpLen=1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        int length = 1;
        for (int i = 0; i < s.length-1; i++) {
            getDif(i);
            if (tmpLen>length){
                length = tmpLen;
            }
            tmpLen = 1;
        }
        System.out.println(length);
    }

    private static void getDif(int i){
        if (s[i]!=s[i+1]){
            if (i!=s.length-2) {
                getDif(i + 1);
            }
            tmpLen++;
        }
    }
}
