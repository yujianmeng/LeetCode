package facetime;

import java.util.Scanner;

/**
 * Created by yujian on 2017/12/14.
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 输入描述:
 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


 输出描述:
 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。

 输入例子1:
 4
 1 2 3 4

 输出例子1:
 4 2 1 3
 */
public class NReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        N head = new N(0);
        N first = new N(scanner.nextInt());
        head.next = first;
        first.upper = head;
        N p = first;
        int i = 2;
        while (i<=n){
            N now = new N(scanner.nextInt());
            if (i%2==0){
                p.next = now;
                now.upper=p;
                p = now;
            }
            else {
                now.next = head.next;
                head.next.upper = now;
                head.next = now;
                now.upper = head;
            }
            i++;
        }
        StringBuffer result = new StringBuffer("");
        if (n%2==0){
            N it = p;
            do{
                result.append(it.value+" ");
                it = it.upper;
            }while (it.upper!=null);
        }
        else {
            N it = head;
            while (it.next!=null){
                result.append(it.next.value+" ");
                it = it.next;
            }
        }
        System.out.println(result.toString().trim());
    }
}

class N{
    int value;
    N next = null;
    N upper = null;
    public N(int value){
        this.value = value;
    }
}