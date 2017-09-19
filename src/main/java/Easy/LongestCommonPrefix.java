package Easy;

/**
 * Created by yujian on 2017/9/19.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] strs = {"aaa"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        String longestPrefix = strs[0];
        for (int i = 1;i<strs.length;i++){
            while (longestPrefix.indexOf(strs[i])!=0){
                strs[i] = strs[i].substring(0,strs[i].length()-1);
                if (strs[i].length()==0)
                    return "";
            }
            longestPrefix = strs[i];
        }

        return longestPrefix;
    }
}
