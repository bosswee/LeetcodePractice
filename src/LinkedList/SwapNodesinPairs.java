package LinkedList;

/**
 * Created by Wee on 2015/4/11.
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //递归，不符合题意

        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null))
                return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }

    //非递归

    public ListNode swapPairs1(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode n1 = helper, n2 = head;

        while (n2 != null && n2.next != null) {
            ListNode temp = n2.next.next;
            n2.next.next = n1.next;
            n1.next = n2.next;
            n2.next = temp;
            n1 = n2;
            n2 = n1.next;
        }

        return helper.next;
    }
    //Best Answer

    public ListNode swapPairs2(ListNode head) {
        ListNode start = new ListNode(0); //make head no longer a special case
        start.next = head;

        for (ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap1(cur.next, cur.next.next);
        }
        return start.next;
    }

    private ListNode swap1(ListNode next1, ListNode next2) {
        next1.next = next2.next;
        next2.next = next1;
        return next2;
    }
}
