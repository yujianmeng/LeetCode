package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/11/7.
 * 问题描述
 　　小明的公司每个月给小明发工资，而小明拿到的工资为交完个人所得税之后的工资。假设他一个月的税前工资（扣除五险一金后、未扣税前的工资）为S元，则他应交的个人所得税按如下公式计算：
 　　1） 个人所得税起征点为3500元，若S不超过3500，则不交税，3500元以上的部分才计算个人所得税，令A=S-3500元；
 　　2） A中不超过1500元的部分，税率3%；
 　　3） A中超过1500元未超过4500元的部分，税率10%；
 　　4） A中超过4500元未超过9000元的部分，税率20%；
 　　5） A中超过9000元未超过35000元的部分，税率25%；
 　　6） A中超过35000元未超过55000元的部分，税率30%；
 　　7） A中超过55000元未超过80000元的部分，税率35%；
 　　8） A中超过80000元的部分，税率45%；
 　　例如，如果小明的税前工资为10000元，则A=10000-3500=6500元，其中不超过1500元部分应缴税1500×3%=45元，超过1500元不超过4500元部分应缴税(4500-1500)×10%=300元，超过4500元部分应缴税(6500-4500)×20%=400元。总共缴税745元，税后所得为9255元。
 　　已知小明这个月税后所得为T元，请问他的税前工资S是多少元。
 输入格式
 　　输入的第一行包含一个整数T，表示小明的税后所得。所有评测数据保证小明的税前工资为一个整百的数。
 输出格式
 　　输出一个整数S，表示小明的税前工资。
 样例输入
 9255
 样例输出
 10000
 评测用例规模与约定
 　　对于所有评测用例，1 ≤ T ≤ 100000。
 */
public class Tollage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        double myMoney = 0;
        if (money<=3500){
            myMoney = money;
        }
        else if (money>3500&&money<=4955){
            myMoney = (money-105)/0.97;
        }
        else if (money>4955&&money<=7655){
            myMoney = (money-455)/0.9;
        }
        else if (money>7655&&money<=11255){
            myMoney = (money-1255)/0.8;
        }
        else if (money>11255&&money<=30755){
            myMoney = (money-1880)/0.75;
        }
        else if (money>30755&&money<=44755){
            myMoney = (money-3805)/0.7;
        }
        else if (money>44755&&money<=61005){
            myMoney = (money-6730)/0.65;
        }
        else {
            myMoney = (money-15080)/0.55;
        }
        System.out.println((int)myMoney);
    }
}
