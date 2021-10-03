package cafe.plastic.leetcode;

import java.util.*;

public class s0040 {

    HashMap<Integer, Integer> counter = new HashMap<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int candidate : candidates) {
            if (counter.containsKey(candidate)) {
                counter.put(candidate, counter.get(candidate) + 1);
            } else {
                counter.put(candidate, 1);
            }
        }
        int idx = 0;
        for (int key : counter.keySet()) {
            candidates[idx++] = key;
        }
        this.candidates = new int[idx];
        for (int i = 0; i < this.candidates.length; i++) {
            this.candidates[i] = candidates[i];
        }
        this.target = target;
        Arrays.sort(this.candidates);
        return findCombinations();
    }
    private List<List<Integer>> findCombinations() {
        Stack<Integer> currentCombination = new Stack<>();
        List<List<Integer>> combinations = new ArrayList<>();
        currentCombination.push(0);
        subFromCounter(0);
        while (!currentCombination.empty()) {
            if (currentCombination.peek() >= candidates.length) {
                currentCombination.pop();
                if (!currentCombination.empty()) {
                    int removed = currentCombination.pop();
                    addToCounter(removed);
                    int next = nextAvailable(removed + 1);
                    currentCombination.push(next);
                    subFromCounter(next);
                }
                continue;
            }
            int sum = sumUp(currentCombination);
            if (sum == target) {
                combinations.add(buildCombination(currentCombination));
            }

            if (sum >= target) {
                int removed = currentCombination.pop();
                addToCounter(removed);
                int next = nextAvailable(removed + 1);
                currentCombination.push(next);
                subFromCounter(next);
            } else {
                int next = nextAvailable(currentCombination.peek());
                currentCombination.push(next);
                subFromCounter(next);
            }
        }
        return combinations;
    }

    private int sumUp(Stack<Integer> nums) {
        int sum = 0;
        for (int num: nums) {
            sum += candidates[num];
        }
        return sum;
    }

    private void addToCounter(int num) {
        if (num >= candidates.length) return;
        counter.put(candidates[num], counter.get(candidates[num]) + 1);
    }

    private void subFromCounter(int num) {
        if (num >= candidates.length) return;
        counter.put(candidates[num], counter.get(candidates[num]) - 1);
    }

    private ArrayList<Integer> buildCombination(Stack<Integer> stack) {
        ArrayList<Integer> combination = new ArrayList<>();
        for(int num: stack) {
            combination.add(candidates[num]);
        }
        return combination;
    }
    private int nextAvailable(int num) {
        int res = candidates.length;
        for(int i = num; i < candidates.length; i++) {
            if (counter.get(candidates[i]) > 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}


