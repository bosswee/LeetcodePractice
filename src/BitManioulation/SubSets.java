package BitManioulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wee on 2015/4/15.
 * Given a set of distinct integers, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 拷贝构造函数或者List或Set等各种集合类的addAll()方法仅仅创建了集合的浅拷贝，而且原始集合和克隆集合指向相同的对象。
 为避免这个问题，应该深克隆集合，遍历集合克隆每个元素。尽管这要求集合中的对象必须支持深克隆操作。
 */
public class SubSets {//更好的办法用位运算做。
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
                ArrayList<Integer> tmpres = new ArrayList<Integer>();
                dfs(S, 0, tmpres);
                return res;
            }

        private static void dfs ( int[] S, int i, ArrayList<Integer > tmpres){
            if (i == S.length) {
         res.add((List<Integer>) tmpres.clone());//深拷贝
            return;
        }
        tmpres.add(S[i]);
        dfs(S,i+1,tmpres);

        tmpres.remove(tmpres.size()-1);//tmpres remove为什么会把res的中的值改变？？
        dfs(S,i+1,tmpres);//尼玛不知道哪错了
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.print(subsets(test));
    }

}
