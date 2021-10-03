package cafe.plastic.leetcode;

import java.util.*;

public class s0051 {
    private final List<String> queenRows = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        buildQueenRows();
        List<List<String>> result = new ArrayList<>();
        solve(result, null);
        return result;
    }

    private void solve(List<List<String>> solutions, Stack<Integer> workingResult) {
        if (workingResult == null) workingResult = new Stack<>();
        if (workingResult.size() == n) {
            solutions.add(buildBoard(workingResult));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!workingResult.contains(i) && isValid(workingResult, i)) {
                workingResult.push(i);
                solve(solutions, workingResult);
                workingResult.pop();
            }
        }
    }
    private List<String> buildBoard(List<Integer> sequence) {
        ArrayList<String> result = new ArrayList<>();
        for(int row: sequence) {
            result.add(queenRows.get(row));
        }
        return result;
    }
    private void buildQueenRows() {
        for(int i = 0; i < n; i++) {
            StringBuilder queenRow = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if (j == i) queenRow.append("Q");
                else queenRow.append(".");
            }
            queenRows.add(queenRow.toString());
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
