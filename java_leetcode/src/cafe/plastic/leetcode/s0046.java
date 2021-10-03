package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class s0046 {
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> combinations = new ArrayList<>();
        permute(null, null, combinations);
        return combinations;
    }

    private void permute(HashSet<Integer> excluded, List<Integer> combination, List<List<Integer>> combinations) {
        if (combination == null) combination = new ArrayList<>();
        if (excluded == null) excluded = new HashSet<>();
        if (combination.size() == nums.length) {
            combinations.add(combination);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (excluded.contains(i)) continue;
            combination.add(nums[i]);
            excluded.add(i);
            permute(excluded,new ArrayList<>(combination), combinations);
            excluded.remove(i);
            combination.remove(combination.size() - 1);
        }
    }
}
