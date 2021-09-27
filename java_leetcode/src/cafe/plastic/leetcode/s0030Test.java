package cafe.plastic.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class s0030Test {
    @Test
    void findSubstring() {
        s0030 solver = new s0030();
        List<Integer> result = solver.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        Integer[] expected = {8};
        assertEquals(2, result.size());
        for(int i = 0; i < result.size(); i++) {
            assertEquals(expected[i], result.get(i));
        }
    }
}