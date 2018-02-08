package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/12/1.
 * 问题描述
 　　消除类游戏是深受大众欢迎的一种游戏，游戏在一个包含有n行m列的游戏棋盘上进行，棋盘的每一行每一列的方格上放着一个有颜色的棋子，当一行或一列上有连续三个或更多的相同颜色的棋子时，这些棋子都被消除。当有多处可以被消除时，这些地方的棋子将同时被消除。
 　　现在给你一个n行m列的棋盘，棋盘中的每一个方格上有一个棋子，请给出经过一次消除后的棋盘。
 　　请注意：一个棋子可能在某一行和某一列同时被消除。
 输入格式
 　　输入的第一行包含两个整数n, m，用空格分隔，分别表示棋盘的行数和列数。
 　　接下来n行，每行m个整数，用空格分隔，分别表示每一个方格中的棋子的颜色。颜色使用1至9编号。
 输出格式
 　　输出n行，每行m个整数，相邻的整数之间使用一个空格分隔，表示经过一次消除后的棋盘。如果一个方格中的棋子被消除，则对应的方格输出0，否则输出棋子的颜色编号。
 样例输入
 4 5
 2 2 3 1 2
 3 4 5 1 4
 2 3 2 1 3
 2 2 2 4 4
 样例输出
 2 2 3 0 2
 3 4 5 0 4
 2 3 2 0 3
 0 0 0 4 4
 样例说明
 　　棋盘中第4列的1和第4行的2可以被消除，其他的方格中的棋子均保留。
 样例输入
 4 5
 2 2 3 1 2
 3 1 1 1 1
 2 3 2 1 3
 2 2 3 3 3
 样例输出
 2 2 3 0 2
 3 0 0 0 0
 2 3 2 0 3
 2 2 0 0 0
 样例说明
 　　棋盘中所有的1以及最后一行的3可以被同时消除，其他的方格中的棋子均保留。
 评测用例规模与约定
 　　所有的评测用例满足：1 ≤ n, m ≤ 30。
 */
public class Eliminate {
    private static int[][] arr;
    private static int n;
    private static int m;
    private static int[][] jilu;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n][m];
        int i = 0;
        while (i<n){
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
            i++;
        }
        jilu = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                get(j,k);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if(jilu[j][k]==1){
                    arr[j][k]=0;
                }
                System.out.print(arr[j][k]+" ");
            }
            System.out.println();
        }
    }
    private static void get(int i,int j){
        int hang = 1;
        int lie = 1;
        for (int k = j; k < m-1; k++) {
            if(arr[i][k]==arr[i][k+1]){
                hang++;
            }
            else {
                break;
            }
        }
        if (hang>=3){
            for (int k = 0; k < hang; k++) {
                jilu[i][j+k] = 1;
            }
        }
        for (int k = i; k < n-1; k++) {
            if (arr[k][j]==arr[k+1][j]){
                lie++;
            }
            else {
                break;
            }
        }
        if (lie>=3){
            for (int k = 0; k < lie; k++) {
                jilu[i+k][j] = 1;
            }
        }
    }
}
