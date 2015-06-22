package BFSAndDFS;

/**
 * Created by Wee on 2015/5/13.
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 对于每一个子树，限制它的最大，最小值，如果超过则返回false。
 对于根节点，最大最小都不限制；
 每一层节点，左子树限制最大值小于根，右子树最小值大于根；
 但是比较有趣的是，在递归的过程中还得不断带入祖父节点的值。

 或者，中序遍历该树，然后扫描一遍看是否递增。
 */
public class ValidateBST {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
  //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    //迭代



}
