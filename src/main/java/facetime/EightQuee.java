package facetime;

/**
 * Created by yujian on 2017/11/15.
 * 八皇后问题
 */
public class EightQuee {
    private static final int N = 8;
    private static int[][]  arr = new int[N+1][N+1];
    private static int n = 0;
    public static void main(String[] args) {
        trial(1);
    }

    private static void trial(int i){
        if (i>N){
            print();
        }
        else {
            for (int j = 1; j <= N; j++) {
                arr[i][j]=1;
                if (isOk(i,j)){
                    trial(i+1);
                }
                arr[i][j]=0;
            }
        }
    }

    private static void print(){
        n++;
        System.out.println("case:"+n);
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                System.out.print(arr[i][j]+"    ");
            }
            System.out.println();
        }
    }

    private static boolean isOk(int i,int j){
        for (int k = 1; k < i; k++) {
            for (int l = 1; l <= N; l++) {
                if (arr[k][l]==1) {
                    if (l == j || Math.abs(i - k) == Math.abs(j - l)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
