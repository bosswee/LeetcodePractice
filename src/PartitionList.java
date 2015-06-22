/**
 * Created by Wee on 2015/4/16.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
        public ListNode partition(ListNode head,int x){
            ListNode dummy1= new ListNode(0);
            ListNode dummy2= new ListNode(0);
            ListNode curr1=dummy1,curr2=dummy2;
            while (head!=null){
                if (head.val<x){
                    curr1.next= head;
                    curr1= head;
                }else{
                    curr2.next=head;
                    curr2= head;
                }
                head = head.next;
            }
            curr2.next=null;
            curr1.next=dummy2.next;
            return dummy1.next;

        }

}
