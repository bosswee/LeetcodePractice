package Array;

/**
 * Created by Wee on 2015/4/12.
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class SearchRotatedSortedArrayTwo {
    public static boolean search(int[] A, int target) {
        if (A.length == 0) return false;
        int L = 0, R = A.length - 1;
        //
        if (target < A[L] && target > A[R]) return false;

        while (L < R) {

               while (A[L] == A[R]&&L<R) L++;//逻辑的符号化

            int M = (L + R) / 2;
            if (A[M] <= A[R]) {
                if (target > A[M] && target <= A[R]) {
                    L = M + 1;
                } else {
                    R = M;
                }

            } else {
                if (target <= A[M] && target >= A[L]) {
                    R = M;
                } else {
                    L = M + 1;
                }
            }
        }
        if (A[L] == target) return true;
         return false;
    }

    public static void main(String[] args) {
        int[] test1 = {1,1,1,3,1};
        int[] test2 ={1,1};
        int target =3;
      //  System.out.print(search(test1,target));
        System.out.print(search(test2,0));
    }
}
