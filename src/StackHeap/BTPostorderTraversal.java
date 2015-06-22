package StackHeap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Wee on 2015/4/10.
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */
public class BTPostorderTraversal {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
        //递归做法
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> tree = new ArrayList<Integer>();
        if (root == null) return tree;

        helper(tree, root);
        return tree;
    }

    public void helper(ArrayList<Integer> tree, TreeNode node) {
        // exit
        if (node == null) return;

        // left sub-tree
        helper(tree, node.left);

        // right sub-tree
        helper(tree, node.right);

        // root
        tree.add(node.val);
        return;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> result = new LinkedList<Integer>();

        while (root != null) {
            result.addFirst(root.val);//利用addfirst将前序遍历翻转
            if (root.left != null) {
                stack.push(root.left);
            }
            root = root.right;
            if (root==null&&!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return result;


    }
}
