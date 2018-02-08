package facetime;


import java.util.Scanner;

/**
 * Created by yujian on 2017/12/26.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i<n) {
            arr[i] = scanner.nextInt();
            i++;
        }
        quick_sort(arr,0,n-1);
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }

    private static void quick_sort(int[] arr,int left,int right){
        if (left<right){
            int x = arr[left];
            int l = left;
            int r = right;
            while (l<r) {
                while (l < r && arr[r] >= x) {
                    r--;
                }
                if (l < r) {
                    arr[l++] = arr[r];
                }
                while (l < r && arr[l] < x) {
                    l++;
                }
                if (l < r) {
                    arr[r--] = arr[l];
                }
            }
            arr[l] = x;
            quick_sort(arr,left,l-1);
            quick_sort(arr,l+1,right);
        }
    }
}
