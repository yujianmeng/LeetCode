package ccf;

import java.util.Scanner;

/**
 * Created by yujian on 2017/12/2.
 * 问题描述
 　　给定一个年份y和一个整数d，问这一年的第d天是几月几日？
 　　注意闰年的2月有29天。满足下面条件之一的是闰年：
 　　1） 年份是4的整数倍，而且不是100的整数倍；
 　　2） 年份是400的整数倍。
 输入格式
 　　输入的第一行包含一个整数y，表示年份，年份在1900到2015之间（包含1900和2015）。
 　　输入的第二行包含一个整数d，d在1至365之间。
 输出格式
 　　输出两行，每行一个整数，分别表示答案的月份和日期。
 样例输入
 2015
 80
 样例输出
 3
 21
 样例输入
 2000
 40
 样例输出
 2
 9
 */
public class RiQi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int days = scanner.nextInt();
        int month = 0;
        int day = 0;
        boolean isRun = isRui(year);
        int er = 28;
        if (isRun){
            er = 29;
        }
        if (days-31<=0){
            month = 1;
            day = days;
        }
        else if (days-31-er<=0){
            month = 2;
            day = days-31;
        }
        else if (days-62-er<=0){
            month = 3;
            day = days-31-er;
        }
        else if(days-92-er<=0){
            month = 4;
            day = days-62-er;
        }
        else if (days-123-er<=0){
            month=5;
            day = days-92-er;
        }
        else if (days-153-er<=0){
            month=6;
            day = days-123-er;
        }
        else if (days-184-er<=0){
            month=7;
            day = days-153-er;
        }
        else if (days-215-er<=0){
            month=8;
            day = days-184-er;
        }
        else if (days-245-er<=0){
            month=9;
            day = days-215-er;
        }
        else if (days-276-er<=0){
            month=10;
            day = days-245-er;
        }
        else if (days-306-er<=0){
            month=11;
            day = days-276-er;
        }
        else {
            month = 12;
            day = days-306-er;
        }
        System.out.println(month);
        System.out.println(day);

    }
    private static boolean isRui(int year){
        if (year%4==0&&year%100!=0){
            return true;
        }
        else if (year%400==0){
            return true;
        }
        else {
            return false;
        }
    }
}
