package BinarySearch;

/**
 * Created by Wee on 2015/4/10.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 使用二分查找，若中间数大于等于最左端数，那左半部分必定有序，否则右半部分有序，
 通过将目标数与有序部分的最大与最小数比较就可以判断目标数位于哪一部分
 */
public class FindMininRotatedSortedArray {
    public int findMin(int[] num) {
        if (num.length==0){
            return 0;
        }
        return findMin(num,0,num.length-1);

    }

    private int findMin(int[] num, int start, int end) {

        int mid = (start+end)/2;
        if(num[mid]>num[end]){
            return findMin(num,mid+1,end);
        }else if (num[mid]<num[end]){
           return  findMin(num,start,mid);
        }else {
            return num[mid];
        }
    }

    public int findMin2(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}
