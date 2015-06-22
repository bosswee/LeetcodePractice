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
            res.add(new ArrayList<Integer>(tmp));//��㸴��
            tmp.remove(tmp.size()-1);
            return;
        }else{
            pathSum(root.left,sum-root.val,tmp,res);
            pathSum(root.right,sum-root.val,tmp,res);
        }
        tmp.remove(tmp.size()-1);//���ڵ���Ҫ��Ҫ�ָ��ֳ������ʣ�ϸ�����⣬�о���ȫ��һ��DFS��֮����һ���Իָ�
    }


}
