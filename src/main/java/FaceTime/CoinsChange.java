package FaceTime;

import java.util.Scanner;

/**
 * Created by yujian on 2017/10/9.
 */
public class CoinsChange {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        //面值为i需要的硬币数
        int[] coinsUsed = new int[money+1];
        coinsUsed[0] = 0;
        //硬币面额（已做升序处理）
        int[] values = {10,5,1};
        makeExchange(money,values,coinsUsed);
    }

    public static void makeExchange(int money,int[] values,int[] coinsUsed){
        int coinsLength = values.length;

        //将需要找零的money分解成子问题并保存子问题最优解
        for (int i=1;i<=money;i++){
            //初始化所需的最小硬币数
            int minCoins = i;
            //遍历硬币面额，将其进行分解
            for (int j=0;j<coinsLength;j++){
                if (values[j]<=i){
                    int temp = coinsUsed[i-values[j]]+1;
                    if (temp<minCoins)
                        minCoins = temp;
                }
            }
            //保存最小硬币数
            coinsUsed[i] = minCoins;
            System.out.println("面值为"+i+"的最小硬币数为："+minCoins);
        }

    }

}
