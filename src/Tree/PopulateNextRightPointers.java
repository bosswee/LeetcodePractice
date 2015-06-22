package Tree;

/**
 * Created by Wee on 2015/4/8.
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class PopulateNextRightPointers {
    public class TreeLinkNode {
            int val;
            TreeLinkNode left,right,next;
            TreeLinkNode(int x) {
                val = x;
            }
        }


        public void connect (TreeLinkNode root){
            //根据题目意思不能做递归，迭代，设定levelstart/cur两个指针DFS遍历，这道题是树的层序遍历Binary Tree Level Order Traversal的扩展
            TreeLinkNode level_start = root;
            while (level_start != null) {
                TreeLinkNode cur = level_start;
                while (cur != null) {
                    if (cur.left != null) cur.left.next = cur.right;
                    if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                    cur = cur.next;
                }
                level_start = level_start.left;
            }


        }


    public void connect2(TreeLinkNode root) {

        TreeLinkNode leftWall = root;
        while (leftWall != null) {

            TreeLinkNode across = leftWall;
            while (across != null) {
                if (across.left != null) {
                    across.left.next = across.right;
                }

                if (across.right != null && across.next != null) {
                    across.right.next = across.next.left;
                }

                across = across.next;
            }
            leftWall = leftWall.left;
        }
    }
}
