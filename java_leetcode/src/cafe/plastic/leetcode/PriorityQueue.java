package cafe.plastic.leetcode;

import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    ArrayList<T> heap;
    public PriorityQueue() {
        heap = new ArrayList<T>();
    }

    public void push(T t) {
        heap.add(t);
        this.siftUp(heap.size() - 1);
    }

    public T pop() {
        if (heap.size() > 0){
            T head = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            siftDown(0);
            return head;
        } else {
            return null;
        }
    }

    public T peek() {
        if (heap.size () > 0) {
            return heap.get(0);
        } else {
            return null;
        }
    }

    public int size() {
        return heap.size();
    }

    public void siftUp(int index) {
        if(index == 0) return;
        int parent = (int)Math.floor((index - 1)/2.0);
        if (heap.get(parent).compareTo(heap.get(index)) < 0) {
            T temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            this.siftUp(parent);
        }
    }

    public void siftDown(int index) {
        int childOne = index*2 + 1;
        int childTwo = index*2 + 2;
        if (childTwo < heap.size()) {
            if (heap.get(index).compareTo(heap.get(childOne)) < 0 || heap.get(index).compareTo(heap.get(childTwo)) < 0 ){
                T temp = heap.get(index);
                if(heap.get(childOne).compareTo(heap.get(childTwo)) < 0) {
                    heap.set(index, heap.get(childTwo));
                    heap.set(childTwo, temp);
                    siftDown(childTwo);
                } else {
                    heap.set(index, heap.get(childOne));
                    heap.set(childOne, temp);
                    siftDown(childOne);
                }
            }
        }
    }

}
