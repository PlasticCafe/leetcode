package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s0039 {
    List<List<Integer>> combinations = new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target= target;
        Arrays.sort(candidates);
        combine(new ArrayList<>(), 0);
        return combinations;
    }

    void combine(ArrayList<Integer> sequence, int start) {
        int sum = sumUp(sequence);
        if (sum == target) {
            combinations.add(sequence);
        } else if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                if (sum + i <= target) {
                    ArrayList<Integer> copy = new ArrayList<>(sequence);
                    copy.add(candidates[i]);
                    combine(copy, i);
                }
            }
        }
    }

    int sumUp(ArrayList<Integer> sequence) {
        int sum = 0;
        for (int i: sequence) {
            sum += i;
        }
        return sum;
    }

}
