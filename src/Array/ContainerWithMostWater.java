package Array;

/**
 * Created by Wee on 2015/4/23.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.

 Note: You may not slant the container.
 * 当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。

 假定初始的盛水面积为ans=0，lh为左边的高度，rh为右边的高度，如果lh < rh, 则向右运动，寻找第一个比当前lh大的左节点。同理，如果lh > rh，则向左运动，寻找第一个比当前rh大的右节点。

 截止条件为坐标L >= R。
 */
public class ContainerWithMostWater {

    //想要变得大一点，只有增加高度以期望超过宽度的减少。

    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
