package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0041Test {

    @Test
    void firstMissingPositive() {
        s0041 solver = new s0041();
        assertEquals(2, solver.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}