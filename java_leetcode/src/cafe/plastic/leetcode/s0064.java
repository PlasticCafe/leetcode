package cafe.plastic.leetcode;

public class s0064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = grid[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    table[i][j] += Math.min(table[i-1][j], table[i][j-1]);
                } else {
                    if (i - 1 >= 0) {
                        table[i][j] += table[i-1][j];
                    }
                    if (j - 1 >= 0) {
                        table[i][j] += table[i][j-1];
                    }
                }
            }
        }
        return table[m - 1][n - 1];
    }
}
