import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wee on 2015/4/14.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 We can use a HashSet to add and remove elements. HashSet is implemented by using a hash table. Elements are not ordered. The add,
 remove and contains methods have constant time complexity O(1).
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num.length==0)return  0;

        Set<Integer> set = new HashSet<Integer>();
        int max=1;
        for(int e:num)set.add(e);

        for (int e:num){
            int left=e-1;
            int right=e+1;
            int count =1;

           while (set.contains(left)){
               count++;
               set.remove(left);//减少时间复杂度
               left--;
           }
            while (set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            max=Math.max(max,count);

           }

        return  max;
    }
}
