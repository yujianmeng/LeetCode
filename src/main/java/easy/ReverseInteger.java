package easy;


/**
 * Created by yujian on 2017/9/16.
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int reverse = 0;
        String xString;
        StringBuilder xStringBuilder;
        if (x>Math.pow(2,31)-1||x<-Math.pow(2,31))
            return reverse;
        else {
            xString = x+"";
            if (x<0)
                xStringBuilder = new StringBuilder(xString.substring(1));
            else
                xStringBuilder = new StringBuilder(xString);
            try{
                reverse = Integer.parseInt(xStringBuilder.reverse().toString());
            }catch (NumberFormatException e){
                return 0;
            }
            return x<0?-reverse:reverse;
        }
    }
}
