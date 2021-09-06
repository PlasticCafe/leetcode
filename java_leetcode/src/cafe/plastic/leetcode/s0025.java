package cafe.plastic.leetcode;

import java.util.ArrayList;

public class s0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {return head;}
        ArrayList<ListNode> nodes = new ArrayList<>();
        enumerate(head, nodes);
        for(int i = 0; (i + k - 1) < nodes.size(); i += k) {
            reverse(nodes, i, i + k - 1);
        }
        return rebuild(nodes);
    }

    public void enumerate(ListNode head, ArrayList<ListNode> nodes) {
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
    }

    public void reverse(ArrayList<ListNode> list, int start, int end) {
        while (start < end) {
            ListNode temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public ListNode rebuild(ArrayList<ListNode> nodes) {
        for (int i = 0; i + 1 < nodes.size(); i++) {
            nodes.get(i).next = nodes.get(i + 1);
            nodes.get(i + 1).next = null;
        }
        return nodes.get(0);
    }
}
