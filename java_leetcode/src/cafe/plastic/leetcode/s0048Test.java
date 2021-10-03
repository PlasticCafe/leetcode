package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0048Test {

    @Test
    void rotate() {
        s0048 solver = new s0048();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solver.rotate(matrix);
        for (int[] row: matrix) {
            System.out.println(row[0] + " " + row[1] + " " +row[2]);
        }
    }
}

/*Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]*/