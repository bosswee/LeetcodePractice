package Tree;

/**
 * Created by Wee on 2015/3/27.
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree
 、in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(SameTree.TreeNode root) {


        if (root==null) return true;
        if (root.left==null && root.right==null) return true;

        if (Math.abs(countDepth(root.left) - countDepth(root.right))>1) return false;

        return (isBalanced(root.left) && isBalanced(root.right));

    }



    public int countDepth(SameTree.TreeNode r){
        if (r==null) return 0;
        if (r.left==null && r.right==null) return 1;
        return 1+Math.max(countDepth(r.left), countDepth(r.right));
    }
    //depth calculation and determining whether the tree is height-balanced or not could finish in one recursive loop.
}
