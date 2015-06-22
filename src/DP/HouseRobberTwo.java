package DP;

/**
 * Created by Wee on 2015/5/21.
 * Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much
 attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
 tonight without alerting the police.
 解题思路：
 讨论是否抢劫第一件房屋。如果是，则不可以抢最后一件房屋。否则，可以抢最后一间房屋。

 以此为依据，将环形DP问题转化为两趟线性DP问题，可以复用House Robber的代码。

 另外需要特判一下只有一件房屋的情形
 */
public class HouseRobberTwo {
    public int rob(int[] nums) {
        int le = nums.length;
        if (le == 0) return 0;
        else if (le == 1) return nums[0];
        else if (le == 2) return Math.max(nums[0], nums[1]);
        //Create an array to store the sums
        int[] arr = new int[le];
        arr[0] = nums[0];
        arr[1] = nums[1];
        // Exclude the last value in the nums array, and calculate the sum just like you do if the houses are in linear order
        for (int i = 2; i < le - 1; i++) {
            if (i > 2) arr[i] = Math.max(arr[i - 2], arr[i - 3]) + nums[i];
            else arr[i] = arr[i - 2] + nums[i];
        }
        // Find the maximum excluding the last house
        int maxWithOutLast = Math.max(arr[le - 2], arr[le - 3]);
        arr[2] = nums[2];
        // Exclude the first value in the nums array, and calculate the sum just like you do if the houses are in linear order
        for (int i = 3; i < le; i++) {
            if (i > 3) arr[i] = Math.max(arr[i - 2], arr[i - 3]) + nums[i];
            else arr[i] = arr[i - 2] + nums[i];
        }
        // Find the maximum excluding the first house
        int maxWithOutFirst = Math.max(arr[le - 2], arr[le - 1]);
        // Return the maximum of the two
        return Math.max(maxWithOutLast, maxWithOutFirst);
    }
}
