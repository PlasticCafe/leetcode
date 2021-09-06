package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class s0022 {
    private final List<String> combinations = new ArrayList<>();
    public List<String> generateParenthesis(int n ) {
        parenRecurse("", n, 0, 0);
        return combinations;
    }

    private void parenRecurse(String string, int max, int open, int close) {
        if (string.length() == max * 2) {
            combinations.add(string);
        } else {
            if (open < max) {
                parenRecurse(string.concat("("), max, open + 1, close);
            }
            if(close < open) {
                parenRecurse(string.concat(")"), max, open, close + 1);
            }
        }
    }

}
