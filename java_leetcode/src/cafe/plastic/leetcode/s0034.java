package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class s0034 {
    public int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num: nums) numsList.add(num);
        int index = Collections.binarySearch(numsList, target);
        if (index < 0) return new int[]{-1, -1};
        int left = index;
        int right = index;
        while (true) {
            if (left - 1 >= 0 && numsList.get(left - 1) == target) {
                left--;
            }
            else if ( right + 1 < numsList.size() && numsList.get(right + 1) == target) {
                right++;
            } else {
                break;
            }
        }
        return new int[]{left, right};
    }
}
