package Medium;

/**
 * Created by yujian on 2017/9/18.
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    //O(n)
    public int maxArea(int[] height) {
        int maxContainer = 0;
        int l = 0;
        int r = height.length-1;
        while (l<r){
            maxContainer = Math.max(maxContainer,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxContainer;
    }


    //时间复杂度太高O(n的平方)
    /*public int maxArea(int[] height) {
        int maxContainer = 0;
        for (int i=0;i<height.length-1;i++)
            for (int j=i+1;j<height.length-1;j++)
                maxContainer = Math.max(maxContainer,(j-i)*Math.min(height[i],height[j]));
        return maxContainer;
    }*/
}
