import java.util.*;

/**
 * Created by Wee on 2015/4/14.
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class FlattenBTToLinkedList {
    public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }

    public void flatten(TreeNode root) {//失败，下次完成
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
        TreeNode p =root;
        for (int i = 0; i <result.size() ; i++) {
            if (p!=null){
                p.val=result.indexOf(i);
               if(p.left!=null)
                p.left=null;
                p=p.right;
            }
        }


    }

    public void flatten2(TreeNode root) {
        //Go down through the left, when right is not null, push right to stack.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.empty()) {

            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                TreeNode temp = stack.pop();
                p.right = temp;
            }

            p = p.right;
        }
    }





}
