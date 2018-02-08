package medium;

/**
 * Created by yujian on 2017/9/15.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /*public static String longestPalindrome(String s) {
        String longestPalindromic = "";
        String tempChar = "";
        int length = s.length();
        int splitLength = 0;
        int i = 0;
        boolean flag = false;
        if (length==1)
            longestPalindromic = s;
        else{
            while (i<length){
                if(tempChar.equals("")||!(tempChar.charAt(0)==s.charAt(i))) {
                    if (flag) {
                        if (tempChar.length() > longestPalindromic.length())
                            longestPalindromic = tempChar;
                        i = i - tempChar.length()+1;
                        tempChar = "";
                        flag = false;
                    }
                    else{
                        tempChar = tempChar+s.charAt(i);
                        i++;
                        if (i==length) {
                            i = i - tempChar.length() + 1;
                            tempChar = "";
                        }
                    }
                }
                else{
                    tempChar = tempChar+s.charAt(i);
                    String repeat = "";
                    for (int j=0;j<tempChar.length();j++)
                        repeat = repeat+s.charAt(i);
                    flag = tempChar.equals(repeat);
                    if (flag&&i!=length-1)
                        i++;
                    else{
                        splitLength = tempChar.length()/2;
                        String s1 = tempChar.substring(0,splitLength);
                        String s2 = tempChar.substring(tempChar.length()%2==0?splitLength:splitLength+1);
                        if (s1.equals(new StringBuilder(s2).reverse().toString()))
                            if (tempChar.length()>longestPalindromic.length())
                                longestPalindromic = tempChar;
                        i = i-tempChar.length()+2;
                        tempChar = "";
                        flag = false;
                    }
                }
            }
        }
        return longestPalindromic.equals("")?s.charAt(0)+"":longestPalindromic;
    }*/
}
