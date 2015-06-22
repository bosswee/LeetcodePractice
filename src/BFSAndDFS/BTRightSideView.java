package BFSAndDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wee on 2015/5/4.
 *
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 The core idea of this algorithm:

 1.Each depth of the tree only select one node.
 2. View depth is current size of result list.
 */
public class BTRightSideView {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }



    public List<Integer> rightSideView(TreeNode root) {
        //每一层只能从左到右的顺序加一个val
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public List<Integer> rightSideView2(TreeNode root) {
        //迭代，用queue保存node
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            //get size here
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if (i == 0) {
                    result.add(top.val);
                }
                //add right first
                if (top.right != null) {
                    queue.add(top.right);
                }
                //add left
                if (top.left != null) {
                    queue.add(top.left);
                }
            }
        }

        return result;
    }
}


