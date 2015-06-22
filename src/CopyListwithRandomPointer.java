/**
 * Created by Wee on 2015/5/19.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 1. ���뿽���ڵ�

 2. ����randomָ��

 3.�ֽ������������б�


 */
public class CopyListwithRandomPointer {
    static class RandomListNode{
        int label;
        RandomListNode next,random;
        RandomListNode(int x){
            this.label=x;
        }
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        head.random = n3;
        n2.random = n4;
        RandomListNode ret = copyRandomList(head);
        while (ret != null) {
            System.out.println(ret.label);
            ret = ret.next;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        RandomListNode copyHead = null;
        RandomListNode copyCur = null;

        // �γ�ͼ1
        while (cur != null) {
            copyCur = new RandomListNode(cur.label);
            if (copyHead == null) {
                copyHead = copyCur;
            }
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = cur.next.next;
        }

        // �γ�ͼ2
        // ע��˴�����Ҫ�ֳ�����while loop�����ܺϲ���
        // ����ϲ�����������randomָ�뻥���γɻ�ʱ�����
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;        // ����copy�ڵ��randomָ��
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            copyCur = cur.next;
            cur.next = cur.next.next;            // �ָ�cur�ڵ��nextָ��
            copyCur.next = cur.next != null ? cur.next.next : null;        // ����copy�ڵ��nextָ��
            cur = cur.next;
        }

        return copyHead;
    }
}
