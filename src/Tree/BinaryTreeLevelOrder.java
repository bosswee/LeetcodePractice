package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Wee on 2015/3/31.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class BinaryTreeLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        LinkedList<TreeNode> nodequeue=new LinkedList<TreeNode>();
        nodequeue.offer(root);
        TreeNode levellast=root;
        ArrayList<Integer> storeeachlevel=new ArrayList<Integer>();

        while(nodequeue.size()>0){
            TreeNode current=nodequeue.poll();
            storeeachlevel.add(current.val);
            if(current.left!=null) nodequeue.offer(current.left);
            if(current.right!=null) nodequeue.offer(current.right);

            if(current==levellast){
                result.add(storeeachlevel);
                storeeachlevel=new ArrayList<Integer>();
                levellast=nodequeue.peekLast();
            }

        }

        return result;



    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

