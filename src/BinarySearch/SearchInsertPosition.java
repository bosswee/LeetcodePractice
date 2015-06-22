package BinarySearch;

/**
 * Created by Wee on 2015/4/2.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >=target) {
                return i;
            }
        }
         return A.length;
    }
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;//利用2分法提高效率 Arrays.BinarySearch()方法也可以。
    }

}
