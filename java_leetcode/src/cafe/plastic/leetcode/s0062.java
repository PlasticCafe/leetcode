package cafe.plastic.leetcode;

public class s0062 {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        table[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] > 0) {
                    if (j + 1 < n) {
                        table[i][j + 1] += table[i][j];
                    }
                    if (i + 1 < m) {
                        table[i + 1][j] += table[i][j];
                    }
                }
            }
        }
        return table[m - 1][n - 1];
    }
}
