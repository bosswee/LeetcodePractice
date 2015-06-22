import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wee on 2015/4/5.
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path
 from the root node down to the nearest leaf node.
 */
public class MinDepthOfBinaryTree {
        public class TreeNode {
                int val;
                TreeNode left;
                TreeNode right;
                TreeNode(int x) {
                    val = x;
                }
            }//BFS或者DFS,以下2为BFS非递归
    public int minDepth2(TreeNode root) {

            if (root == null) {
                return 0;
            }
           Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        int level = 1;
        currentLevel.add(root);
        while (true) {
            TreeNode node = currentLevel.poll();

            if (node.left == null && node.right == null) {
                return level;
            }
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }

            if (currentLevel.isEmpty()) {
                // swap
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                ++level;
            }
        }
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

}
