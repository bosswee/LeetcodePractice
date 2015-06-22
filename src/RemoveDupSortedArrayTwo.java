/**
 * Created by Wee on 2015/4/13.
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 这道题跟Remove Duplicates from Sorted Array比较类似，区别只是这里元素可以重复出现至多两次，而不是一次。

 其实也比较简单，只需要维护一个counter，当counter是2
 时，就直接跳过即可，否则说明元素出现次数没有超，继续放入结果数组，若遇到新元素则重置counter。
 总体算法只需要扫描一次数组，所以时间上是O(n)，空间上只需要维护一个index和counter，所以是O(1)。
 */
public class RemoveDupSortedArrayTwo {
    public int removeDuplicates(int[] A) {
        if(A.length<3)return A.length;
       int idx =0;
        int count =0;
        for (int i = 0; i < A.length ; i++) {
            if (i>0&&A[i]==A[i-1]){
                count++;
                if(count>3)
                    continue;
            }else {
                count =1;
            }
            A[idx++]=A[i];
        }
        return idx;
    }

}
