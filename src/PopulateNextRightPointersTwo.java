/**
 * Created by Wee on 2015/4/26.
 * follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 区别在于：每个节点的next节点可以在横向上找到存在的那个节点，无论是父节点next节点的左或者右孩子，又或者是父节点next的next节点的左或者右节点。。。

 因此，这道题目首要是找到右孩子的第一个有效的next链接节点，然后再处理左孩子。然后依次递归处理右孩子，左孩子

 这道题目的要求和Populating Next Right Pointers in Each Node是一样的，只是这里的二叉树没要求是完全二叉树。其实在实现Populating Next Right Pointers in Each
 Node的时候我们已经兼容了不是完全二叉树的情况，其实也比较好实现，就是在判断队列结点时判断一下他的左右结点是否存在就可以了。具体算法就不再分析了，不熟悉的朋友可以看看Populating Next Right Pointers in Each
 Node。时间复杂度和空间复杂度不变，还是O(n)和O(1)。

 这道题本质是树的层序遍历，只是队列改成用结点自带的链表结点来维护。
 */
public class PopulateNextRightPointersTwo {
    //尚待练习
    public class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode curHead = null;
        while (lastHead != null) {
            TreeLinkNode lastCur = lastHead;
            while (lastCur != null) {
                if (lastCur.left != null) {
                    if (curHead == null) {
                        curHead = lastCur.left;
                        pre = curHead;
                    } else {
                        pre.next = lastCur.left;
                        pre = pre.next;
                    }
                }
                if (lastCur.right != null) {
                    if (curHead == null) {
                        curHead = lastCur.right;
                        pre = curHead;
                    } else {
                        pre.next = lastCur.right;
                        pre = pre.next;
                    }
                }
                lastCur = lastCur.next;

            }
            lastHead = curHead;
            curHead = null;
        }
    }
}