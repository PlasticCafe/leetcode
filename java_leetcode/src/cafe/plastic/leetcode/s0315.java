package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class s0315 {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Item> items = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            items.add(new Item(nums[i], i, 0));
        }
        mergeSort(0, items.size() - 1, items);
        ArrayList<Integer> result = new ArrayList<>();
        for (Item item: items) {
            nums[item.index] = item.count;
        }
        for (int num: nums) {
            result.add(num);
        }
        return result;
    }

    void mergeSort(int a, int b, ArrayList<Item> items) {
        if (b - a + 1 == 2) {
            Item temp = items.get(a);
            if (items.get(a).val > items.get(a + 1).val) {
                items.set(a, items.get(a + 1));
                items.set(a + 1, temp);
                items.get(a + 1).count++;
            }
        } else if (b - a + 1 > 2){
            mergeSort(a, (int) (a + Math.floor((b - a)/2.0)), items);
            mergeSort((int) (a + Math.floor((b - a)/2.0) + 1), b, items);
            merge(a, (int)(a + Math.floor((b - a)/2.0)), (int)(a + Math.floor((b-a)/2.0) + 1), b, items);
        }
    }

    void merge (int a, int b, int c, int d, ArrayList<Item> items) {
        ArrayList<Item> tlist = new ArrayList<>();
        int headOne = a;
        int headTwo = c;
        int jumps = 0;
        while (headOne <=b && headTwo <= d) {
            if (items.get(headOne).val <= items.get(headTwo).val ) {
                tlist.add(items.get(headOne++));
                if (tlist.size() > 1) {
                    tlist.get(tlist.size() - 1).count += jumps;
                }
            } else {
                tlist.add(items.get(headTwo++));
                jumps++;
            }
        }
        while (headOne <= b) {
            tlist.add(items.get(headOne++));
            if (tlist.size() > 1) {
                tlist.get(tlist.size() - 1).count += jumps;
            }
        }

        while (headTwo <= d) {
            tlist.add(items.get(headTwo++));
        }
        for (int i = 0; i < tlist.size(); i++) {
            items.set(i + a, tlist.get(i));
        }
    }

    class Item {
        public int val;
        public int index;
        public int count;
        Item(int val, int index, int count) {
            this.val = val;
            this.index = index;
            this.count = count;
        }
    }

}
