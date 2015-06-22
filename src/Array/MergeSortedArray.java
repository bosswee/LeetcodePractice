package Array;

/**
 * Created by Wee on 2015/3/11.
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {

        int k = m + n - 1, i = m - 1, j = n - 1;
        while(j >= 0) {
            if(i >= 0 && A[i] >= B[j])  // i >=0, in case A is empty
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }
}
