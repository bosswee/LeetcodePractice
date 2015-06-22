package LinkedList;

/**
 * Created by Wee on 2015/4/18.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 Analysis:

 One of the key tricks is to set up 2 pointers, distance between which equal to n-m.  Therefore, when the left pointer reached m position,
 the right pointer would reach n position as wee.

 After we got the node at position m and the node at position n, we move node at position m to the position after node n one by one,
 until all the nodes before node n processed. For example:

 Original linked list:       1->2->3->4->5->6->7; m = 3, n =6

 Step1:        1->2->4->5->6->3->7

 Step2:      1->2->5->6->4->3->7

 ......

 Result:      1->2->6->5->4->3->7

 Note that pointer m is switching to right one by one in each step, but pointer n remains no change.

 Finally, we need to consider about the case that reverse range started from the very beginning of the linked list.  In this case,
 we should return the pointer n rather than return the original head of the linked list.（思路2）
 这样的题目关键是不要怕麻烦，一定要画多几个链表图，一步一步演算，这样思路就很清晰了。
 通过头痛折磨的训练之后，这些题目不用调试，一次性AC。
 */
public class ReverseLinkedListTwo {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 4个指针


    public ListNode reverseBetween(ListNode head, int m, int n) {//思路1，转换过程有待研究
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {//两个连续指针就能reverse链表，怎么做到的？
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {//这个清晰
        // init m node and n node
        ListNode mNode = head;
        ListNode nNode = head;

        // previous node of node m
        ListNode mPreNode = new ListNode(0);
        mPreNode.next = head;

        // set up the distance between node m and node n
        for (int i = 0; i < n - m; i++) nNode = nNode.next;

        // locate node m and node n
        for (int i = 0; i < m - 1; i++) {
            mPreNode = mNode;
            mNode = mNode.next;
            nNode = nNode.next;
        }

        // check if case of reversing from head
        boolean fromHead = false;
        if (mNode == head) fromHead = true;

        // reverse node range  将m不断插到n后面然后指针往后移动直到m,n相遇。
        while (mNode != nNode) {
            ListNode temp = nNode.next;
            nNode.next = mNode;
            mPreNode.next = mNode.next;
            mNode.next = temp;
            mNode = mPreNode.next;
        }

        // case of reverse started from head，或者可以定义一个safe guard返回它的next就不用判断了
        if (fromHead == true) return nNode;

        // other cases
        return head;
    }

    }
