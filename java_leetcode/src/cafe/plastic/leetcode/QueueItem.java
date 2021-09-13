package cafe.plastic.leetcode;

public class QueueItem<T> implements Comparable<QueueItem<T>> {
    public T val;
    public int priority;

    public QueueItem(T val, int priority) {
        this.val = val;
        this.priority = priority;
    }
    @Override
    public int compareTo(QueueItem<T> o) {
        return Integer.compare(this.priority, o.priority);
    }
}
