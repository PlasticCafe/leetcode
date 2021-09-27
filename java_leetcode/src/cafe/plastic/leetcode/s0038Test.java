package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0038Test {

    @Test
    void countAndSay() {
        s0038 solver = new s0038();
        String output = solver.countAndSay(4);
        assertEquals("1211", output);
    }
}