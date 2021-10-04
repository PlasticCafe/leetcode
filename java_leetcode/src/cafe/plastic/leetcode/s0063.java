package cafe.plastic.leetcode;

public class s0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        table[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    table[i][j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    table[i][j] += table[i][j - 1];
                }
                if (i - 1 >= 0) {
                    table[i][j] += table[i - 1][j];
                }
            }
        }
        return table[m - 1][n - 1];
    }
}
