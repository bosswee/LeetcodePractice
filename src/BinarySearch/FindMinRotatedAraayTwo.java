package BinarySearch;

/**
 * Created by Wee on 2015/4/12.
 * Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 We only need to add one more condition,
 which checks if the left-most element and the right-most element
 are equal. If they are we can simply drop one of them.
 In my solution below,
 I drop the left element whenever the left-most equals to the right-most.
 */
public class FindMinRotatedAraayTwo {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public int findMin(int[] num, int left, int right) {
        if (right == left) {
            return num[left];
        }
        if (right == left + 1) {
            return Math.min(num[left], num[right]);
        }
        // 3 3 1 3 3 3

        int middle = (right - left) / 2 + left;
        // already sorted
        if (num[right] > num[left]) {
            return num[left];
            //right shift one
        } else if (num[right] == num[left]) {
            return findMin(num, left + 1, right);
            //go right
        } else if (num[middle] >= num[left]) {
            return findMin(num, middle, right);
            //go left
        } else {
            return findMin(num, left, middle);
        }
    }

}
