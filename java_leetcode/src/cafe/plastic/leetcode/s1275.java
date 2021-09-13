package cafe.plastic.leetcode;

public class s1275 {
    int diagOneTest;
    int diagTwoTest;
    int rowTest;
    int colTest;
    int n;

    public s1275() {
        n = 3;
        diagOneTest = ((1 << (n*n + n)) - 1) / ((1 << (n + 1)) - 1);
        diagTwoTest = (((1 << (n*n - 1)) - 1) / ((1 << n - 1) - 1)) - 1;
        rowTest = (1 << n) - 1;
        colTest = ((1 << n*n) - 1) / (( 1 << n) - 1);
    }

    public String tictactoe(int[][] moves) {
        int aMoves = 0;
        int bMoves = 0;
        boolean aMove = true;
        for (int[] move: moves) {
            if (aMove) {
                aMoves |= 1 << (move[0] * n + move[1]);
            } else {
                bMoves |= 1 << (move[0] * n + move[1]);
            }
            aMove = !aMove;
        }
        if (testWin(aMoves)) {
            return "A";
        } else if (testWin(bMoves)) {
            return "B";
        } else {
            if (moves.length == 9) {
                return "Draw";
            } else {
                return "Pending";
            }
        }
    }

    public boolean testWin(int moves) {
        if ((moves & diagOneTest) == diagOneTest || (moves & diagTwoTest) == diagTwoTest) {
            return true;
        } else {
            for (int i = 0; i < n; i ++) {
                int rowTestI = rowTest << n*i;
                if ((moves & rowTestI) == rowTestI) {
                    return true;
                }

                int colTestI = colTest << i;
                if ((moves & colTestI) == colTestI) {
                    return true;
                }
            }
        }
        return false;
    }
}
