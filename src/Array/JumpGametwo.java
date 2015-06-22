package Array;

/**
 * Created by Wee on 2015/5/19.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 比较典型的贪心。维护一个区间，区间表示第i步所能到达的索引范围。递推的方法为：
 每次都遍历一遍当前区间内的所有元素，从一个元素出发的最远可达距离是index+array[index]，那么下一个区间的左端点就是当前区间的右端点+1，下一个区间的右端点就是当前区间的max
 (index+array[index])，以此类推，直到区间包含了终点，统计当前步数即可。

 实现代码：
 */
public class JumpGametwo {

    public int jump(int[] A) {
            if (A.length == 1)
                return 0;
            int max = 0, count = 1, begin = 0, end = A[0];
            while (end < A.length - 1) {
                count++;
                int index = begin;//因为index之后还要用，所以放在循环外
                for (; index <= end; index++) {
                    max = Math.max(max, index + A[index]);
                }
                begin = index;
                end = max;
            }
            return count;
        }

}
