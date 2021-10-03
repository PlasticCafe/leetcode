package cafe.plastic.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class s0052 {
    int n;
    int count = 0;
    public int totalNQueens(int n) {
        this.n = n;
        solve(null, null);
        return count;
    }

    private void solve(Stack<Integer> workingResult, HashSet<Integer> excluded) {
        if (workingResult == null) workingResult = new Stack<>();
        if (excluded == null) excluded = new HashSet<>();
        if (workingResult.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!excluded.contains(i) && isValid(workingResult, i)) {
                workingResult.push(i);
                excluded.add(i);
                solve(workingResult, excluded);
                workingResult.pop();
                excluded.remove(i);
            }
        }
    }

    private boolean isValid(List<Integer> sequence, int candidate) {
        if(sequence.contains(candidate)) return false;
        int i = sequence.size() - 1;
        int j = candidate - 1;
        while( i >=0 && j >= 0) {
            if(sequence.get(i--) == j--) {
                return false;
            }
        }

        i = sequence.size() - 1;
        j = candidate + 1;
        while( i >=0 && j >= 0) {
            if(sequence.get(i--) == j++) {
                return false;
            }
        }
        return true;
    }
}
