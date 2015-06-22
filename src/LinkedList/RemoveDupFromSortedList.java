package LinkedList;

/**
 * Created by Wee on 2015/4/21.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDupFromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode FakeHead = new ListNode(0);
        FakeHead.next=head;
        ListNode pre = FakeHead;
        ListNode cur = head;
        while (cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;//有重复，cur后移，最后去掉
            }
            if(pre.next==cur){
                pre=pre.next;//无重复，pre后移
            }else{
                pre.next=cur.next;//有重复，去掉重复
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
//recursive
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
