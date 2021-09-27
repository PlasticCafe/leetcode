package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0031Test {

    @Test
    void nextPermutation() {
        int[] input = {2, 3, 1, 3, 3};
        int[] expected = {2, 3, 3, 1, 3};
        s0031 solver = new s0031();
        solver.nextPermutation(input);
        for (int i = 0; i < input.length; i++) {
            assertEquals(expected[i], input[i]);
        }

    }
}