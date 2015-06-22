package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/5/25.
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each
 * combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        combinationSum3(new ArrayList<Integer>(), 0, 1, 0, k, n, results);
        return results;
    }

    private void combinationSum3(List<Integer> list, int total, int next, int level, int k, int n, List<List<Integer>> results) {
        if (level == k) {
            if (total == n) {
                List<Integer> l = new ArrayList<Integer>(list);//Éî¿½±´
                results.add(l);
            }
            return;
        }
        for (int i = next; i <= 9; i++) {
            list.add(i);
            combinationSum3(list, total + i, i + 1, level + 1, k, n, results);
            list.remove(list.size() - 1);//»ØËÝ
        }
    }
}
