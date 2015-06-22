package BinarySearch;

import java.util.Arrays;

/**
 * Created by Wee on 2015/5/12.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        //题目意思是求连续的子数组，明显是不能排序的，Wrong
        Arrays.sort(nums);
        int sum =0;
        for (int i = nums.length-1; i >=0; i--) {
            sum+=nums[i];
            if (sum>=s)return nums.length-i;
        }
        return 0;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        //两个指针遍历数组，返回长度的最小值，O(N)
        if (nums.length == 0) return 0;
        int first = 0;
        int second = 0;
        int min = nums.length + 1;
        int sum = nums[0];
        while (first < nums.length && second <= first) {

            if (sum < s) {
                first++;
                if (first < nums.length)
                    sum += nums[first];
            } else {
                min = Math.min(first - second + 1, min);
                sum -= nums[second];
                second++;

            }
        }

        if (min == nums.length + 1) return 0;
        return min;
    }
    //As to NLogN solution, logN immediately reminds you of binary search. In this case, you cannot sort as the current order actually
    // matters. How does one get an ordered array then? Since all elements are positive, the cumulative sum must be strictly increasing.
    // Then, a subarray sum can expressed as the difference between two cumulative sum. Hence, given a start index for the cumulative sum
    // array, the other end index can be searched using binary search.

    private int solveNLogN(int s, int[] nums) {//尚待研究,构造一个递增序列以便二分搜索，
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
