package LinkedList;

/**
 * Created by Wee on 2015/4/9.
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public boolean hasCycle(ListNode head) {
            //只要存在cycle，fast最终会赶上slow;
            ListNode fast =head;
            ListNode slow =head;

            if(head==null||head.next==null){
                return false;
            }

            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if (fast==slow){
                    return true;
                }
            }
            return false;
        }
}
