package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class s0040 {
    List<List<Integer>> combinations = new ArrayList<>();
    HashSet<Integer> uniqueCheck = new HashSet<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        combine(new ArrayList<>(), 0);
        return combinations;
    }

    void combine(ArrayList<Integer> sequence, int start) {
        int sum = sumUp(sequence);
        if (sum == target) {
            if (!uniqueCheck.contains(hash(sequence))) {
                combinations.add(sequence);
                uniqueCheck.add(hash(sequence));
            }
        } else if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                        ArrayList<Integer> copy = new ArrayList<>(sequence);
                        copy.add(candidates[i]);
                        combine(copy, i + 1);
                }
            }
        }
    }
    //1, 1, 1, 3, 3, 5
    int hash(ArrayList<Integer> sequence) {
        int hash = 0;
        for(int digit = 0; digit < sequence.size(); digit++) {
            hash = ((hash + digit + 1)* sequence.get(digit)) << digit;
        }
        return hash;
    }

    int sumUp(ArrayList<Integer> sequence) {
        int sum = 0;
        for (int i : sequence) {
            sum += i;
        }
        return sum;
    }

}


