package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class s0045Test {

    @Test
    void jump() {
        s0045 solver = new s0045();
        assertEquals(2, solver.jump(new int[]{2,3,1,1,4}));
    }
}