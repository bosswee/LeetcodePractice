package Tree;

import java.util.*;

/**
 * Created by Wee on 2015/4/9.
 * Given a binary tree,
 * return the preorder traversal of its nodes' values.
 */
public class BTPreorderTraversal {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
       while(root !=null){
           result.add(root.val);
           if(root.right!=null){
              stack.push(root.right);
               }
            root=root.left;
           if(root==null&&!stack.isEmpty()){
               root=stack.pop();
           }
       }

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
