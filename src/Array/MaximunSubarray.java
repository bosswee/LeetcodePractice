package Array;

/**
 * Created by Wee on 2015/4/9.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 Hide Tags Divide and Conquer Array Dynamic Programming

 */
public class MaximunSubarray {
    public int maxSubArray(int[] A) {
        //一维DP,局部最优解,重复子问题
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0]=A[0];
        for (int i = 1; i <A.length ; i++) {
            sum[i]= Math.max(A[i],sum[i-1]+A[i]);//包含i的前i字符的最大值
            max= Math.max(max,sum[i]);
        }

            return max;




    }
}
