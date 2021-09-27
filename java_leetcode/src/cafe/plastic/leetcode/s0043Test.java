package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0043Test {

    @Test
    void multiply() {
        s0043 solver = new s0043();
        assertEquals("56088", solver.multiply("123", "456"));
    }
}