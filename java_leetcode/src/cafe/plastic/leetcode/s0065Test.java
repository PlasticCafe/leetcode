package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0065Test {
    s0065 solver = new s0065();
    @Test
    void isNumber() {
        boolean output = solver.isNumber("005047e+6");
        assertTrue(output);
    }
}