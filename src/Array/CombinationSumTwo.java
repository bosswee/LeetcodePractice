package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wee on 2015/5/16.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 这道题跟Combination Sum非常相似，不了解的朋友可以先看看，唯一的区别就是这个题目中单个元素用过就不可以重复使用了。
 乍一看好像区别比较大，但是其实实现上只需要一点点改动就可以完成了，就是递归的时候传进去的index应该是当前元素的下一个。
 */
public class CombinationSumTwo {
   //Todo:这两个NP问题还要研究下
        public List<List<Integer>> combinationSum2(int[] num, int target) {
            //1240
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int m = num.length;
            if (m == 0) return res;
            Arrays.sort(num);
            List<Integer> item = new ArrayList<Integer>();
            dfs(num, target, 0, item, res);
            return res;
        }

        public void dfs(int[] num, int target, int start, List<Integer> item, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(item));
                return;
            }
            if (target < 0) return;
            for (int i = start; i < num.length; i++) {
                if (i > start && num[i] == num[i - 1]) continue;// avoid duplicate solutions
                item.add(num[i]);
                dfs(num, target - num[i], i + 1, item, res);
                item.remove(item.size() - 1);
            }
        }
        //1255
    }


