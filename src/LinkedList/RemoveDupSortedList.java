package LinkedList;

/**
 * Created by Wee on 2015/3/30.
 * Given a sorted linked list, delete all duplicates such that
 * each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDupSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode list = head;
        while(list != null){
            if (list.next==null){
                break;
            }
            if(list.val==list.next.val){
                list.next=list.next.next;
            }else{
                list=list.next;

            }
        }
            return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.val == cur.val) {
                cur = cur.next;
                prev.next = cur;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
