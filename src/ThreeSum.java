import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wee on 2015/3/12.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 1.利用两个指针寻找sum
 2.去重
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {//去重还是错误
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

                for (int j = 0; j < num.length - 2; j++) {
                    if(j > 0 && num[j] == num[j-1])
                        continue;
                    int start = j+1;
                    int end = num.length - 1;
                    while (start < end) {
                        int sum = num[j] + num[start] + num[end];
                        if (sum < 0) {
                            start++;
                            while (start < end && num[start] == num[start-1]) start++;
                        } else if (sum > 0) {
                            end--;
                            while (start < end && num[end] == num[end-1])end--;
                        } else  {
                            List list = new ArrayList<Integer>();
                            list.add(num[j]);
                            list.add(num[start]);
                            list.add(num[end]);
                            result.add(list);
                            start++;//差点忘了...
                          //  result.add(Arrays.asList(num[j], num[start], num[end]));
                        }
                    }
                }


            return result;

    }
    public List<List<Integer>> threeSum2(int[] num) {//正确的
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < num.length-2; ++i) {
            if(i > 0 && num[i] == num[i-1])
                continue;

            int j = i + 1, k = num.length-1;

            while(j < k) {
                int candidate = num[i] + num[j] + num[k];
                if(candidate <= 0) {
                    if(candidate == 0)
                        result.add(Arrays.asList(num[i],num[j], num[k]));
                    ++j;
                    while (j < k && num[j] == num[j-1])
                        ++j;
                }
                else if(candidate > 0) {
                    --k;
                    while (k > j && num[k] == num[k+1])
                        --k;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {-1 ,0 ,1 ,2 ,-1 ,-4};
        System.out.print(threeSum(test));
    }
        }
