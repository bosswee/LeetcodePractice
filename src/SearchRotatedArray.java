/**
 * Created by Wee on 2015/3/10.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchRotatedArray {
   public static int search(int[] A, int target) {
       if (A.length == 0) return -1;
       int L = 0, R = A.length-1;
       //
       if (target < A[L] && target > A[R]) return -1;

       while (L < R) {
           int M = (L + R)/2;
           if (A[M] <= A[R]) {
               if (target > A[M] && target <= A[R]) {
                   L = M+1;
               } else {
                   R = M;
               }

           } else {
               if (target <= A[M] && target >= A[L]) {
                   R = M;
               } else {
                   L = M+1;
               }
           }
       }
       if (A[L] == target) return L;
       else return -1;
 }

    public static void main(String[] args) {
        int[] A = {4,5,6,7,1,2,3};
        search(A,7);

    }
}
