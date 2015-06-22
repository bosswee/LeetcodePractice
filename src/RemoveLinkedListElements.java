/**
 * Created by Wee on 2015/4/23.
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


        public ListNode removeElements (ListNode head,int val){
            ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
            dummy.next = head;
            ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
            ListNode node = head;
            while (node != null) {
                if (node.val == val) {
                    pre.next = node.next;
                    node = node.next;
                } else {
                    pre = pre.next;
                    node = node.next;
                }
            }
            return dummy.next;
        }


    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
