package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//fails the last test case due to n^2 worst case performance on a sorted list
public class s0315Alt {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        BST root = new BST(nums[nums.length - 1]);
        result.add(0);
        if (nums.length == 1) return result;
        for (int i = nums.length - 2; i >= 0; i--) {
            result.addFirst(root.insert(nums[i], 0));
        }
        return result;
    }

    class BST {
        int val;
        int size = 0;
        int dupes = 0;
        BST right = null;
        BST left = null;
        BST(int val) {
            this.val = val;
        }

        int insert(int val, int greaterCount) {
            if (this.val == val) {
                dupes++;
                size++;
                return (this.left != null ? this.left.size + 1: 0) + greaterCount;
            } else if (this.val < val) {
                if (this.right == null) {
                    this.right = new BST(val);
                    size++;
                    return (this.left != null ? this.left.size + 2: 1) + greaterCount + dupes;
                } else {
                    size++;
                    return this.right.insert(val, (this.left != null ? this.left.size + 2: 1) + greaterCount + dupes);
                }
            } else {

                if (this.left == null) {
                    this.left = new BST(val);
                    size++;
                    return greaterCount;
                } else {
                    size++;
                    return this.left.insert(val, greaterCount);
                }
            }
        }
    }
}
