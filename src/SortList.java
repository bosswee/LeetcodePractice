/**
 * Created by Wee on 2015/4/3.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode counter = head;
            int len = 0;
            while (counter != null) {
                counter = counter.next;
                len++;
            }
            ListNode[] headArray = {head};
            return mergeSort(headArray, len);


        }

        private ListNode mergeSort(ListNode[] headArray, int len) {
            if (len == 1) {

                ListNode temp = headArray[0];
                headArray[0] = headArray[0].next;

                temp.next = null;

                return temp;
            }

            ListNode left = mergeSort(headArray, len / 2);
            ListNode right = mergeSort(headArray, len - len / 2);

            return merge(left, right);


        }

        private ListNode merge(ListNode left, ListNode right) {
            if (left == null)
                return right;


            if (right == null)
                return left;


            ListNode preHead = new ListNode(-1);

            ListNode end = preHead;

            while (left != null && right != null) {
                if (left.val < right.val) {
                    end.next = left;
                    left = left.next;
                } else {
                    end.next = right;
                    right = right.next;
                }

                end = end.next;
            }

            if (left != null) {
                end.next = left;
            }

            if (right != null) {
                end.next = right;
            }


            return preHead.next;
        }
    }

    //递归做法，比较容易理解

    public ListNode merge(ListNode s1, ListNode s2) {
        ListNode p = s1, q = s2, s = null;
        ListNode res = new ListNode(0);
        s = res;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                s.next = p;
                p = p.next;
            } else {
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }
        while (p != null) {
            s.next = p;
            s = s.next;
            p = p.next;
        }
        while (q != null) {
            s.next = q;
            s = s.next;
            q = q.next;
        }
        return res.next;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head; // 只剩下一个节点
        ListNode pre = null, p = head, q = head;
        while (q != null && q.next != null) { // 用fast-slow法找到链表中间位置
            pre = p;
            p = p.next;
            q = q.next;
            if (q.next != null) q = q.next;
        }
        pre.next = null; // 从中间位置分成两段，p指针指向右边部分的首节点
        ListNode left = mergeSort(head); // 递归分段左边部分
        ListNode right = mergeSort(p); // 递归分段右边部分
        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return mergeSort(head);
    }
}
