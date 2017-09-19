package Easy;

/**
 * Created by yujian on 2017/9/12.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] indices = twoSum(nums,17);
        System.out.println(indices[0]+","+indices[1]);
    }

    public static int[] twoSum(int[] nums,int target){
        int[] indices=new int[2];
        for (int i=0;i<nums.length;i++){
            int j = i+1;
            while (j<nums.length){
                if (target-nums[i]-nums[j++]==0){
                    indices[0] = i;
                    indices[1] = j-1;
                    break;
                }
            }
        }
        return indices;
    }
}
