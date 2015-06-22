package BFSAndDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/5/19.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumTwo {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
       pathSum(root,sum,tmp,res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {

        if (root==null)return;
        tmp.add(new Integer(root.val));
        if (root.left==null&&root.right==null&&sum==root.val){
            res.add(new ArrayList<Integer>(tmp));//深层复制
            tmp.remove(tmp.size()-1);
            return;
        }else{
            pathSum(root.left,sum-root.val,tmp,res);
            pathSum(root.right,sum-root.val,tmp,res);
        }
        tmp.remove(tmp.size()-1);//关于到底要不要恢复现场的疑问，细节问题，感觉是全部一次DFS完之后再一次性恢复
    }


}
