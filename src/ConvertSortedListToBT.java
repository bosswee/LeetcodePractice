/**
 * Created by Wee on 2015/4/15.
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 思路2这题的难点在于如何找到链表的中间节点，
 * 我们可以通过fast，slow指针来解决，fast每次走两步，slow每次走一步
 * fast走到结尾，那么slow就是中间节点了。
 */
public class ConvertSortedListToBT {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public class TreeNode {
                int val;
                TreeNode left;
                TreeNode right;
                TreeNode(int x) {
                    val = x;
                }
            }

        private static ListNode h;

        public TreeNode sortedListToBST(ListNode head) {
            if (head==null)
                return null;
            h = head;
            int len = getLength(head);
            return  sortedListToBST(0, len - 1);        }

        public int getLength(ListNode head) {
            int len =0;
            ListNode p = head;
            while (p!=null){
                len++;
                p=p.next;
            }
            return len;
        }
        //build tree bottom-up
        public TreeNode sortedListToBST(int start, int end) {
        if(start>end){
            return null;
        }
            int mid=(start+end)/2;

            TreeNode left = sortedListToBST(start,mid-1);
            TreeNode root = new TreeNode(h.val);
            h=h.next;
            TreeNode right = sortedListToBST(mid+1,end);

            root.left=left;
            root.right=right;

            return root;
        }


    }
