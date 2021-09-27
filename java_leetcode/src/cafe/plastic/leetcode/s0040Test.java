package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class s0040Test {

    @Test
    void combinationSum2() {
        s0040 solver = new s0040();
        List<List<Integer>> sums = solver.combinationSum2(new int[]{3, 1, 3, 5, 1, 1}, 8);

    }
}