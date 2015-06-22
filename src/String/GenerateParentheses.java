package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/23.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 //思路还是DFS+backtraceing+具体判断

 我们还是使用九章算法的递归模板。

 1. Left代表余下的'('的数目

 2. right代表余下的')'的数目

 3. 注意right余下的数目要大于left,否则就是非法的，比如，先放一个')'就是非法的。

 4. 任何一个小于0，也是错的。

 5. 递归的时候，我们只有2种选择，就是选择'('还是选择')'。

 6. 递归的时候，一旦在结果的路径上尝试过'('还是选择')'，都需要回溯，即是sb.deleteCharAt(sb.length() - 1);
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
       if (n==0)return result;

           dfs(n,n,new StringBuilder(),result);

           return result;

    }

    private void dfs(int left, int right, StringBuilder sb, List<String> result) {
        if (left==0&&right==0){
            result.add(sb.toString());
            return;
        }

        if (left<0||right<0||left>right){
            return;
        }

        dfs(left-1,right,sb.append('('),result);
        sb.deleteCharAt(sb.length()-1);

        dfs(left,right-1,sb.append(')'),result);
        sb.deleteCharAt(sb.length()-1);
    }
}
