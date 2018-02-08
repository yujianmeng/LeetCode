package ccf;


import java.util.Scanner;

/**
 * Created by yujian on 2017/11/23.
 */
public class SalientPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sales = new int[n];
        int sum = 0;
        int i=0;
        while (i<n){
            sales[i] = scanner.nextInt();
            i++;
        }
        for (int j = 1; j < sales.length-1; j++) {
            int pre = sales[j]-sales[j-1];
            int ne = sales[j+1]-sales[j];
            if (pre*ne<0){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
