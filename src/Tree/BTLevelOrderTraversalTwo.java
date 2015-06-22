package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wee on 2015/4/13.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BTLevelOrderTraversalTwo {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> nodequeue = new LinkedList<TreeNode>();
        nodequeue.offer(root);
        TreeNode levellast = root;
        ArrayList<Integer> storeeachlevel = new ArrayList<Integer>();


        while (nodequeue.size() > 0) {
            TreeNode current = nodequeue.poll();
            storeeachlevel.add(current.val);
            if (current.left != null) nodequeue.offer(current.left);
            if (current.right != null) nodequeue.offer(current.right);

            if (current == levellast) {
                result.addFirst(storeeachlevel);
                storeeachlevel = new ArrayList<Integer>();
                levellast = nodequeue.peekLast();
            }

        }

        return result;


    }
}
