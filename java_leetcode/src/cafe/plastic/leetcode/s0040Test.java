package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class s0040Test {

    @Test
    void combinationSum2() {
        s0040 solver = new s0040();
        List<List<Integer>> sums = solver.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.console().printf("test");
    }
}