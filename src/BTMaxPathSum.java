/**
 * Created by Wee on 2015/5/20.
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 初始印象，DFS，应该把遍历的左中右都相加恰来
 Analysis

 1) Recursively solve this problem
 2) Get largest left sum and right sum
 2) Compare to the stored maximum

 Java Solution

 We can also use an array to store value for recursive methods.
 */
public class BTMaxPathSum {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
    int max;//Todo:把max设置为全局变量是对的，设为局部变量是错的？原因是在子方法里面max依然是局部的无法改
    // 变父方法里面的局部变量？，但是为啥非基本变量数组就可以传递呢，一个是值传递，一个是引用传递吗？
    public int maxPathSum(TreeNode root) {
        //int max[] = new int[1];
        max = Integer.MIN_VALUE;
        calculateSum(root);
        return max;
    }

    public int calculateSum(TreeNode root) {
        if (root == null)
            return 0;

        int left = calculateSum(root.left);
        int right = calculateSum(root.right);

        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

        max = Math.max(max, Math.max(current, left + root.val + right));

        return current;


    }
}
