package medium;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujian on 2017/9/14.
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class LongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int j = 0;
        Map<Character,Integer> tmp = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (!tmp.containsKey(chars[i]))
                tmp.put(chars[i],j++);
            else {
                if (j > length) length = j;
                i = i-j;
                j=0;
                tmp = new HashMap<Character, Integer>();
            }
            if (i == chars.length-1)
                if (j > length) length = j;
        }
        return length;
    }
}
