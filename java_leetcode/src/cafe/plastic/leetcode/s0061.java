package cafe.plastic.leetcode;

public class s0061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        int size = 1;
        ListNode tail = head;
        while(tail.next != null) {
            size++;
            tail = tail.next;
        }
        k = k % size;
        if ( k == 0) return head;
        ListNode kth = head;
        for (int i = 0; i < size - k - 1; i++) {
            kth = kth.next;
        }
        tail.next = head;
        head = kth.next;
        kth.next = null;
        return head;
    }
}
