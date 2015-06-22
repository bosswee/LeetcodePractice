package BFSAndDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Wee on 2015/4/6.
 * Given a binary tree, return the inorder traversal of
 * its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].//使用stack进行inorder遍历

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack= new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
            while (cur!=null)
            {
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return  result;


    }
}
