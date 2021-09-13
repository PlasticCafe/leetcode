package cafe.plastic.leetcode;
public class s0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) { return null;}
        PriorityQueue<QueueItem<ListNode>> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            int priority = lists.length - getListLen(list);
            queue.push(new QueueItem<>(list, priority));
        }

        while(queue.size() > 1) {
            QueueItem<ListNode> one = queue.pop();
            QueueItem<ListNode> two = queue.pop();
            queue.push(new QueueItem<>(mergeTwoLists(one.val, two.val), lists.length - one.priority + two.priority));
        }
        return queue.pop().val;
    }

    public int getListLen(ListNode list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        return len;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode resultHead;
        ListNode currentHead;

        if(l1.val < l2.val) {
            currentHead = l1;
            l1 = l1.next;
        } else {
            currentHead = l2;
            l2 = l2.next;
        }
        resultHead = currentHead;

        while ((l1 != null) || (l2 != null)) {
            if (l1 == null) {
                currentHead.next = l2;
                break;
            } else if (l2 == null) {
                currentHead.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                currentHead.next = l2;
                l2 = l2.next;
            } else {
                currentHead.next = l1;
                l1 = l1.next;
            }
            currentHead = currentHead.next;
        }
        return resultHead;
    }

}
