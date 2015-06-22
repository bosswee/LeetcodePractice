package LinkedList;

/**
 * Created by Wee on 2015/5/16.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    //思路简单，循环的反转链表，实现容易出错，多练习
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null)
            return head;
        ListNode first = head, last = head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode preGroup = preHead, nextGroup = preHead;
        int count = 1;
        while (last != null) {
            if (count == k) {//判断循环
                nextGroup = last.next;
                reverseList(first, last);
                preGroup.next = last;
                preGroup = first;
                first.next = nextGroup;
                first = nextGroup;
                last = nextGroup;
                count = 1;
                continue;
            }
            last = last.next;
            count++;
        }
        return preHead.next;
    }

    private void reverseList(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(-1), node = head;
        pre.next = head;
        while (pre != tail) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
    }

}
