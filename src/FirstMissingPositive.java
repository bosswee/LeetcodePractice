/**
 * Created by Wee on 2015/5/20.
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 [解题思路]
 //其实就是桶排序，只不过不许用额外空间。
 无序数组的题目如果要O(n)解法往往要用到hash table，但这题要求constant space。所以可以用数组本身作为一个"hash table"：A[0] = 1, A[1] = 2, ....
 A[n-1] = n。目标是尽可能将数字i放到数组第i-1个位置。
 扫描数组中每个数：
 1. 如果A[i]<1或者A[i]>n。说明A[i]一定不是first missing positive。跳过
 2. 如果A[i] = i+1，说明A[i]已经在正确的位置，跳过
 3. 如果A[i]!=i+1，且0<A[i]<=n，应当将A[i]放到A[A[i]-1]的位置，所以可以交换两数。
 这里注意，当A[i] = A[A[i]-1]时会陷入死循环。这种情况下直接跳过。


 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] >=1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;//如果A[i] = i+1，说明A[i]已经在正确的位置，跳过
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
}
