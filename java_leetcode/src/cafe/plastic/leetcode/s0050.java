package cafe.plastic.leetcode;

public class s0050 {
    public double myPow(double x, int n) {
        boolean negative = false;
        long remainExp = n;
        if ( remainExp < 0) {
            remainExp *= -1;
            negative = true;
        } else if (remainExp == 0) {
            return 1;
        }

        long currentExp = 1;
        double currentVal = x;
        double result = 1;
        while (remainExp >= 2) {
            if (currentExp * 2 > remainExp) {
                remainExp -= currentExp;
                currentExp = 1;
                result *= currentVal;
                currentVal = x;
                continue;
            }
            currentVal *= currentVal;
            currentExp *= 2;
        }
        if (remainExp == 1) result *= x;
        if (negative) result = 1.0/result;
        return result;
    }

}
