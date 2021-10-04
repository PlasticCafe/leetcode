package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0067Test {
    s0067 solver = new s0067();
    @Test
    void addBinary() {
        assertEquals("10101", solver.addBinary("1010", "1011"));
    }
}