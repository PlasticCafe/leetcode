package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0060Test {
    s0060 solver = new s0060();
    @Test
    void getPermutation() {
        assertEquals("132", solver.getPermutation(3, 2));
    }

    @Test
    void fac() {
        assertEquals(24, solver.fac(4));
    }
}