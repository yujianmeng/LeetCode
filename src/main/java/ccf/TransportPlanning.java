package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/11/22.
 */
public class TransportPlanning {
    static int M = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int total = 0;
        int[][] weight = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                weight[i][j] = M;
            }
        }
        int i=0;
        while (i++<m){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a<b){
                weight[a][b] = c;
            }else {
                weight[b][a] = c;
            }
        }
        int start = 1;
        String[] path = Dijsktra(weight, start);
        //构建start点到所有点都是最短路径的连通图
        int[][] tu = new int[n+1][n+1];
        for (String s:path){
            if (s!=null) {
                String[] arr = s.split("-->");
                if (arr.length == 2 && arr[0].equals(arr[1])) {
                    continue;
                } else {
                    for (int j = 0; j < arr.length - 1; j++) {
                        tu[Integer.valueOf(arr[j])][Integer.valueOf(arr[j + 1])] = 1;
                    }
                }
            }
        }
        for (int j = 0; j < tu.length; j++) {
            for (int k = 0; k < tu.length; k++) {
                if (tu[j][k]==1){
                    total = total+weight[j][k];
                }
            }
        }
        System.out.println(total);

    }


    public static String[] Dijsktra(int[][] weight, int start) {
        int n = weight.length;
        //存放从start到其他各点的最短路径
        int[] shortPath = new int[n];
        //存放从start到其他各点的最短路径的字符串表示
        String[] path = new String[n];
        //当有多条最短路径时，贪心算法始终选择最后一段路径最短的那条最短路径
        int[] lastCost = new int[n];
        for (int i = 1; i < n; i++) {
            path[i] = new String(start + "-->" + i);
        }
        //标记当前该顶点的最短路径是否已经求出,1表示已求出
        int[] visited = new int[n];
        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;
        //要加入n-1个顶点
        for (int count = 1; count <= n - 2; count++){
            //选出一个距离初始顶点start最近的未标记顶点
            int k = -1;
            int dmin = M;
            for (int i = 1; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for (int i = 1; i < n; i++) {
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                    lastCost[i] = weight[k][i];
                }
                if (visited[i] == 0 && weight[start][k] + weight[k][i] == weight[start][i]){
                    if (weight[k][i]<lastCost[i]){
                        path[i] = path[k] + "-->" + i;
                        lastCost[i] = weight[k][i];
                    }
                }
            }
        }
        return path;
    }
}
