package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wee on 2015/4/16.
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsTwo {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] num) {

        Arrays.sort(num);
        ArrayList<Integer> tmpres = new ArrayList<Integer>();
        dfs(num, 0, tmpres);
        return res;
    }

    private static void dfs(int[] S, int i, ArrayList<Integer> tmpres) {
        if (i == S.length) {
           if (!res.contains(tmpres)) res.add((List<Integer>) tmpres.clone());//深拷贝,貌似加个判断就ok了o(╯□╰)o
            return;
        }
        tmpres.add(S[i]);
        dfs(S, i + 1, tmpres);

        tmpres.remove(tmpres.size() - 1);//tmpres remove为什么会把res的中的值改变？？
        dfs(S, i + 1, tmpres);//尼玛不知道哪错了
    }
    }

