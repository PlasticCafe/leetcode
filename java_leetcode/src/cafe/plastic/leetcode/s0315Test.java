package cafe.plastic.leetcode;

import static org.junit.jupiter.api.Assertions.*;

class s0315Test {
    @org.junit.jupiter.api.Test
    void test() {
        int[] input = {3, 5, 3, 11, 1010, 44, 1, 2};
        s0315 solver = new s0315();
        solver.countSmaller(input);
        assertArrayEquals(new int[]{2, 3, 2, 2, 3, 2, 0, 0}, input);
    }

}