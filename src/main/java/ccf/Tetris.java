package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/11/23.
 */
public class Tetris {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ROW = 15;
        int CO = 10;
        int SHAPE = 4;
        int[][] arr = new int[ROW][CO];
        int i = 0;
        //保存每一列最顶端方块的坐标
        int[] y = new int[CO];
        for (int j = 0; j < CO; j++) {
            y[j] = 15;
        }
        while (i<ROW){
            for (int j = 0; j < CO; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j]==1&&y[j]==15){
                    y[j] = i;
                }
            }
            i++;
        }
        int[][] shape = new int[SHAPE][SHAPE];
        i=0;
        while (i<SHAPE){
            for (int j = 0; j < SHAPE; j++) {
                shape[i][j] = scanner.nextInt();
            }
            i++;
        }
        int beginIndex = scanner.nextInt();
        //保存每一列中最后方块的坐标
        int[] a = new int[SHAPE];
        for (int j = 0; j < SHAPE; j++) {
            for (int k = SHAPE-1; k > 0; k--) {
                if (shape[k][j]==1){
                    a[j] = k;
                    break;
                }
            }
        }
        //找出最先接触的坐标
        int pre = 20;
        int index = 0;
        for (int j = 0; j < SHAPE; j++) {
            if (a[j]!=0){
                if(y[j+beginIndex-1]-a[j]<pre){
                    pre = y[j+beginIndex-1]-a[j];
                    index = j;
                }
            }
        }
        for (int j = 0; j < SHAPE; j++) {
            for (int k = 0; k < SHAPE; k++) {
                if (shape[j][k]!=0){
                    int X = y[index+beginIndex-1]-a[index]+j-1;
                    int Y = k+beginIndex-1;
                    arr[X][Y]=1;
                }
            }
        }
        for (int j = 0; j < ROW; j++) {
            for (int k = 0; k < CO; k++) {
                System.out.print(arr[j][k]+" ");
            }
            System.out.println();
        }

    }
}
