package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0057Test {

    @Test
    void insert() {
        s0057 solver = new s0057();
        int[][] input = new int[][]{{1,5}};
        int[] input2 = new int[]{1,7};
        int[][] expectedOutput = new int[][]{{1,7}};
        int[][] output = solver.insert(input, input2);
        assertEquals(expectedOutput.length, output.length);
        for(int i = 0; i < output.length; i++) {
            assertEquals(expectedOutput[i][0], output[i][0]);
            assertEquals(expectedOutput[i][1], output[i][1]);
        }
    }
}