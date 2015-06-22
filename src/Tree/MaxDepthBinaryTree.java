package Tree;

import java.util.ArrayList;

/**
 * Created by Wee on 2015/4/1.
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path
 from the root node down to the farthest leaf node.
 */
public class MaxDepthBinaryTree {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;

        // Non-recursive, use level order triversal
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        int depth = 0;

        while(!q.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for(TreeNode node : q) {
                if(node.left != null)   next.add(node.left);
                if(node.right != null)  next.add(node.right);
            }
            q = new ArrayList<TreeNode>(next);
            depth++;
        }

        return depth;

    }

    public int maxDepth2(TreeNode root) {
        if(root == null)    return 0;

        return getDepth(root, 1);
    }//recurise
    public int getDepth(TreeNode node, int depth) {
        int left = depth, right = depth;
        if(node.left != null) left = getDepth(node.left, depth + 1);
        if(node.right != null) right = getDepth(node.right, depth + 1);

        return left > right ? left : right;
    }
}

