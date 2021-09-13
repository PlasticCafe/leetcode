package cafe.plastic.leetcode;
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5, 6};
        int[] priorities = {6, 5, 4, 3, 2, 5};
        PriorityQueue<QueueItem<Integer>> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < vals.length; i++) {
            priorityQueue.push(new QueueItem<Integer>(vals[i], priorities[i]));
        }

        QueueItem<Integer> item;
        while(true) {
            item = priorityQueue.pop();
            if (item == null) {break;}
            System.out.print(item.val);
        }
    }
}
