package Math;

/**
 * Created by Wee on 2015/4/6.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 思路:This is a simple problem. It can be solved by doing the following:

 Use a flag to mark if previous sum is >= 10
 Handle the situation that one list is longer than the other
 Correctly move the 3 pointers p1, p2 and p3 which pointer to two input lists and one output list
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode newHead = new ListNode(0);
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode p3 = newHead;
            int carry = 0;

            while (p1 != null || p2 != null) {//注意if和while的区别
                if (p1!= null) {
                    carry += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    carry += p2.val;
                    p2 = p2.next;
                }

                p3.next = new ListNode(carry % 10);
                p3 = p3.next;
                carry /= 10;

                if (carry == 1) {
                    p3.next = new ListNode(1);
                }

            }
            return newHead.next;
        }
    }
}
