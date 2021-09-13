package cafe.plastic.leetcode;

public class s1275Alt {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0;
        int antiDiag = 0;
        boolean a = true;
        boolean win = false;
        int turns = 0;

        for (int i = 0; i < moves.length; i++) {
            rows[moves[i][0]] += a ? 1: -1;
            cols[moves[i][1]] += a ? 1: -1;
            if (moves[i][0] == moves[i][1])  {
                diag += a? 1: -1;
            }
            if ((n - 1 - moves[i][0]) == moves[i][1]) {
                antiDiag += a? 1: -1;
            }
            turns++;
            if (Math.abs(rows[moves[i][0]]) == n || Math.abs(cols[moves[i][1]]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
                win = true;
                break;
            }
            a = !a;
        }
        if (win) {
            if (a) return "A";
            else return "B";
        } else {
            if (turns == 9) return "Draw";
            else return "Pending";
        }
    }
}
