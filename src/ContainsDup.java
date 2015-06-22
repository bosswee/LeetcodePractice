import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wee on 2015/5/25.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least
 * twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDup {
    public boolean containsDuplicate(int[] nums) {
        //Hashtable来存储对应的值
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
