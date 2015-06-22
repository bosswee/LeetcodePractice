package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wee on 2015/5/16.
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 这个题是一个NP问题，方法仍然是N-Queens中介绍的套路。
 基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，
 并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。
 算法复杂度因为是NP问题，所以自然是指数量级的
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i <candidates.length; i++) {
            if (candidates[i]<target){
                // use modified array which not includes those numbers that before i to eliminate the duplicates
                int[] array = Arrays.copyOfRange(candidates, i, candidates.length);

                // call this function. pass the new target and modified array.
                List<List<Integer>> temp = combinationSum(array, target - candidates[i]);

                // for each list in the return list, add current number in the front of list, then add it to result
                // attention that if return list is null, this enhanced for loop will not perform.
                for (List<Integer> list : temp) {
                    list.add(0, candidates[i]);
                    res.add(list);}


            }else if (candidates[i]==target){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(candidates[i]);
                res.add(tmp);
            }else{
                return res;
            }
        }
        return res;
    }
}
