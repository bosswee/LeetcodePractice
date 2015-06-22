package TwoPointers;

/**
 * Created by Wee on 2015/4/9.
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 扩展问题
 在网上搜集了一下这个问题相关的一些问题，思路开阔了不少，总结如下：

 1. 环的长度是多少？

 2. 如何找到环中第一个节点（即Linked List Cycle II）？

 3. 如何将有环的链表变成单链表（解除环）？

 4. 如何判断两个单链表是否有交点？如何找到第一个相交的节点？
 思路：
 第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。

 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。

 我们发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。

 2. 我们已经得到了结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。
 */
public class LinkedListCycleTwo {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(true){
                if(fast==null||fast.next==null){
                    return null;}

                    slow = slow.next;
                    fast = fast.next.next;
                if(slow==fast){
                    break;
                }
            }
            slow = head;
           while(slow!=fast){
               slow=slow.next;
               fast=fast.next;
           }
            return slow;

        }
}
