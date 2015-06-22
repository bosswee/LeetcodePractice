import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wee on 2015/3/13.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <num.length-3 ; i++) {
            if(i > 0 && num[i] == num[i-1])
                continue;
            for (int j = 1; j < num.length - 2; j++) {
                int start = j + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i]+num[j] + num[start] + num[end];
                    if (sum < 0) {
                        start++;
                         while (start < end && num[start] == num[start-1]) start++;
                    } else if (sum > 0) {
                        end--;
                         while (start < end && num[end] == num[end-1])end--;
                    } else {
                        List list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        result.add(list);
                        start++;//差点忘了...
                        //  result.add(Arrays.asList(num[j], num[start], num[end]));
                    }
                }
            }

        }


        return  result;
    }
    public static List<List<Integer>> fourSum2(int[] num, int target) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (num == null || num.length < 4)
            return results;
        Arrays.sort(num);

        for (int s = 0; s < num.length - 3; s++) {
            if (s > 0 && num[s] == num[s - 1])  continue;//


            for (int e = num.length - 1; e >= s + 3; e--) {
                if (e < num.length - 1 && num[e] == num[e + 1]) continue;//

                int local = target - num[s] - num[e];
                int j = s + 1;
                int k = e - 1;
                while (j < k) {

                    if (j > s + 1 && num[j] == num[j - 1]) {//
                        j++;
                        continue;
                    }
                    if (k < e - 1 && num[k] == num[k + 1]) {//
                        k--;
                        continue;
                    }

                    if ((num[j] + num[k]) > local)
                        k--;
                    else if ((num[j] + num[k]) < local)
                        j++;
                    else
                        results.add(new ArrayList<Integer>(Arrays.asList(
                                num[s], num[j++], num[k--], num[e])));
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        int[] test = {1 ,0, -1, 0, -2 ,2};
        System.out.print(fourSum2(test, 0));

    }
}
