import java.util.Arrays;

/**
 * Created by Wee on 2015/3/10.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDup {
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2)
            return A;

        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }

        int[] B = Arrays.copyOf(A, j + 1);

        return B;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,1};
          A = removeDuplicates(A);
        System.out.println(A.length);
        for (int i = 0; i <A.length ; i++) {
            System.out.println(A[i]);
        }
    }
}
