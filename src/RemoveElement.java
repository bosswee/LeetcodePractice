import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wee on 2015/3/9.
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int next = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[next++] = A[i];
            }
        }
        return next;
    }

}
