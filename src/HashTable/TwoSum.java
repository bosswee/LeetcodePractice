package HashTable;

import java.util.Hashtable;

/**
 * Created by Wee on 2015/3/12.
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Hashtable<Integer,Integer> tmp = new Hashtable();
        for (int i = 0; i <numbers.length ; i++) {
            if(tmp.containsKey(numbers[i])){
                result[0]= tmp.get(numbers[i])+1;
                result[1]=i+1;
            }
            tmp.put(target-numbers[i],i);
        }
        return  result;
    }
}
