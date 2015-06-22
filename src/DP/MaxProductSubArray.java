package DP;

/**
 * Created by Wee on 2015/5/15.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        //记录每种情况的最大值，O(N2)
        if (nums.length == 0) return 0;
        int max = nums[0];

        for (int i = 0; i <nums.length ; i++) {
            int temp = nums[i];
            max = Math.max(max, temp);
            for (int j = i+1; j <nums.length ; j++) {
                 temp*=nums[j];
                max = Math.max(max,temp);
            }
        }
                return max;
    }
    //这道题跟Maximum
    // Subarray模型上和思路上都比较类似，还是用一维动态规划中的“局部最优和全局最优法”。
    // 这里的区别是维护一个局部最优不足以求得后面的全局最优，这是由于乘法的性质不像加法那样，
    // 累加结果只要是正的一定是递增，乘法中有可能现在看起来小的一个负数，后面跟另一个负数相乘就会得到最大的乘积。
    // 不过事实上也没有麻烦很多，我们只需要在维护一个局部最大的同时，
    // 在维护一个局部最小，这样如果下一个元素遇到负数时，就有可能与这个最小相乘得到当前最大的乘积和，这也是利用乘法的性质得到的

    public int maxProduc2(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];
        int max_local = A[0];
        int min_local = A[0];
        int global = A[0];
        for (int i = 1; i < A.length; i++) {
            int max_copy = max_local;
            max_local = Math.max(Math.max(A[i] * max_local, A[i]), A[i] * min_local);
            min_local = Math.min(Math.min(A[i] * max_copy, A[i]), A[i] * min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.print(maxProduct(arr));
    }
}
