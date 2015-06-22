package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/19.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsTwo {//还有其他更快的方法。。。
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> l : ans) {
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j, num[i]);
                   if(!new_ans.contains(new_l)) new_ans.add(new_l);//仅仅是加个判断条件...
                }
            }
            ans = new_ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,1,2};
        System.out.print(permuteUnique(num));
    }
}
