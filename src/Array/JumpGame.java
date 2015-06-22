package Array;

/**
 * Created by Wee on 2015/5/18.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 We can track the maximum length a position can reach. The key to solve this problem is to find 2 conditions: 1) the position can not reach
 next step (return false) , and 2) the maximum reach the end (return true).
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A.length <= 1)
            return true;

        int max = A[0];

        for (int i = 0; i < A.length; i++) {
            //if not enough to go to next
            if (max <= i && A[i] == 0)
                return false;

            //update max
            if (i + A[i] > max) {
                max = i + A[i];
            }

            //max is enough to reach the end
            if (max >= A.length - 1)
                return true;
        }

        return false;

    }
}
