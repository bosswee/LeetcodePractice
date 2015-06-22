package Array;

/**
 * Created by Wee on 2015/4/23.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColors(int[] A) {
        //My java version is more readable, the basic idea is to use two pointer low and high and an iterator i
      //  every elem left low pointer is 0, elem right high pointer is 2,快速排序的思想
     if(A==null||A.length<2)return;
        int low =0;
        int high = A.length-1;
        for (int i = low; i <high ;) {
            if(A[i]==0){
                //swap A[i] and A{low] and i,low both++
                int temp = A[i];
                A[i]=A[low];
                A[low]=temp;
                i++;low++;
            }else if(A[i]==2) {
                int temp = A[i];
                A[i] = A[high];
                A[high] = temp;
                high--;
            }else{
            i++;
        }
        }
    }

    // two pass O(m+n) space
    void sortColors2(int A[], int n) {
        int num0 = 0, num1 = 0, num2 = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == 0) ++num0;
            else if (A[i] == 1) ++num1;
            else if (A[i] == 2) ++num2;
        }

        for (int i = 0; i < num0; ++i) A[i] = 0;
        for (int i = 0; i < num1; ++i) A[num0 + i] = 1;
        for (int i = 0; i < num2; ++i) A[num0 + num1 + i] = 2;
    }
}
