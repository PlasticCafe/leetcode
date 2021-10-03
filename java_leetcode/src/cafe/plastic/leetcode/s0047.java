package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class s0047 {
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        List<List<Integer>> combinations = new ArrayList<>();
        permute(null, null, combinations);
        return combinations;
    }

    private void permute(HashSet<Integer> excluded, List<Integer> combination, List<List<Integer>> combinations) {
        boolean empty = true;
        if (combination == null) combination = new ArrayList<>();
        if (excluded == null) excluded = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (excluded.contains(i) || (i > 0 && nums[i] == nums[i - 1] && !excluded.contains(i - 1))) continue;
            empty = false;
            combination.add(nums[i]);
            excluded.add(i);
            permute(excluded,new ArrayList<>(combination), combinations);
            excluded.remove(i);
            combination.remove(combination.size() - 1);
        }
        if (empty) combinations.add(combination);
    }
}
