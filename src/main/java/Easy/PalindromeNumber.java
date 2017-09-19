package Easy;

/**
 * Created by yujian on 2017/9/16.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(isPalindrome(10));
    }
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int div = 1;
        while (x/div>=10)
            div*=10;
        while (div>1){
            int first = x/div;
            int tail = x%10;
            if (first != tail)
                return false;
            x = x%div/10;
            div/=100;
        }
        return true;
    }
}
