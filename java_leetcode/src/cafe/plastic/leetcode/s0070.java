package cafe.plastic.leetcode;

import java.util.HashMap;

public class s0070 {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int n1 = 3;
        int n2 = 2;
        for(int i = 4; i <= n; i++) {
            int t = n2;
            n2 = n1;
            n1 = t + n2;
        }
        return n1;
    }
}
