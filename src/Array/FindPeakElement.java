package Array;

/**
 * Created by Wee on 2015/4/11.
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.
 对于这题，最简单地解法就是遍历数组，只要找到第一个元素，大于两边就可以了，复杂度为O(N)。但这题还可以通过二分来做。

 首先我们找到中间节点mid，如果大于两边返回当前index就可以了，如果左边的节点比mid大，那么我们可以继续在左半区间查找，这里面一定存在一个peak，为什么这么说呢？假设此时的区间范围为[0,
 mid - 1]， 因为num[mid - 1]一定大于num[mid]了，如果num[mid - 2] <= num[mid - 1]，那么num[mid - 1]就是一个peak。如果num[mid - 2] > num[mid - 1]，那么我们就继续在[0,
 mid - 2]区间查找，因为num[-1]为负无穷，所以最终我们绝对能在左半区间找到一个peak。同理右半区间一样。

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    //递归
    public int findPeakElement(int[] num) {
        return Helper(num,0,num.length-1);
    }

    private int Helper(int[] num, int low, int high) {
        if (low==high)
            return low;
        else{
            int mid1 =(low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1]>num[mid2])
                return Helper(num,low,mid1);
            else{
                return Helper(num,mid2,high);
            }
        }
    }
//N,顺序
    public int findPeakElement1(int[] num){
        for (int i = 1; i <num.length; i++) {
            if(num[i]<num[i-1]){
                return  i-1;
            }

        }

        return num.length-1;
    }
    //二分法的迭代实现
    public  int findPeekElement2(int[] num){
        int low =0;
        int high = num.length-1;
        while(low<high){
            int mid1=(low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1]<num[mid2])
                low=mid2;
            else
                high=mid1;
        }
        return low;
    }


}
