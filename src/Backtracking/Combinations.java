package Backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *    在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。
 *    当探索到某一结点时，要先判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，
 *    则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。

 若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。
 * Created by Wee on 2015/4/14.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        Deque<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for (int i = 1; i <=n ; i++) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(i);
            queue.add(list);
        }

        while (!queue.isEmpty()){
            List<Integer> list = queue.pollFirst();
            if(list.size()==k){
                result.add(list);
            }else{
                for (int i = list.get(list.size()-1)+1; i <=n ; i++) {
                    List<Integer> nextlist = new LinkedList<Integer>();
                    nextlist.addAll(list);
                    nextlist.add(i);
                    queue.addLast(nextlist);
                }
            }
        }
            return result;



    }
}
