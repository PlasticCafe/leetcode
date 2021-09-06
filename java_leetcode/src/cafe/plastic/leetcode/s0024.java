package cafe.plastic.leetcode;

import java.util.ArrayList;

public class s0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ArrayList<ListNode> nodes = new ArrayList<>();
        enumerate(head, nodes);
        for(int i = 0; i + 1 < nodes.size(); i += 2) {
            swap(nodes, i, i + 1);
        }
        return rebuild(nodes);
    }

    public void enumerate(ListNode head, ArrayList<ListNode> nodes) {
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
    }

    public void swap(ArrayList<ListNode> list, int one, int two) {
        ListNode temp = list.get(one);
        list.set(one, list.get(two));
        list.set(two, temp);
    }

    public ListNode rebuild(ArrayList<ListNode> nodes) {
        for (int i = 0; i + 1 < nodes.size(); i++) {
            nodes.get(i).next = nodes.get(i + 1);
            nodes.get(i + 1).next = null;
        }
        return nodes.get(0);
    }
}
