import java.util.Arrays;

/**
 * Created by Wee on 2015/3/11.
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element
 always exist in the array.
 ）*/
public class Majority {
    public int majorityElement(int[] num) {
        Arrays.sort(num);
       return num[num.length/2];



    }
    public int majorityElement2(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
