package cafe.plastic.leetcode;

public class s0048 {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i ++) {
            for(int j = 0; j < matrix.length - matrix.length/2; j++) {
                int temp = 0;
                int end = matrix.length - 1;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][end - i];
                matrix[j][end - i] = temp;

                temp = matrix[i][j];
                matrix[i][j] = matrix[end - i][end - j];
                matrix[end - i][end - j] = temp;

                temp = matrix[i][j];
                matrix[i][j] = matrix[end - j][i];
                matrix[end - j][i] = temp;

                temp = matrix[i][j];
                matrix[i][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
