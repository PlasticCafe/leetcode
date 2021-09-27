package cafe.plastic.leetcode;

public class s0029 {
    public int divide(int dividend, int divisor) {
        int result = 0;
        if (dividend == divisor) result = 1;
        else if (dividend == 0 || divisor == Integer.MIN_VALUE) result = 0;
        else if (divisor == 1) result = dividend;
        else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result =  ~dividend + 1;
            }
        } else {
            int exp = 0;
            int count = 0;
            boolean negative = (dividend < 0) != (divisor < 0);
            boolean min = false;
            if (divisor < 0) divisor = ~(divisor) + 1;
            if (dividend == Integer.MIN_VALUE) {
                min = true;
                dividend = ~(dividend + 1) + 1;
            } else if (dividend < 1) {
                dividend = ~(dividend) + 1;
            }
            int tDividend = dividend;
            int tDivisor = divisor;
            if (divisor < 0) tDivisor = ~(divisor) + 1;
            while (tDividend >= divisor) {
                if ((tDivisor & 0x40000000) == 0x40000000) {
                    tDividend -= tDivisor;
                    count += Math.pow(2, exp);
                    exp = 0;
                    tDivisor = divisor;
                } else if (tDividend >= tDivisor << 1) {
                    exp++;
                    tDivisor = tDivisor << 1;
                } else {
                    tDividend -=  tDivisor;
                    count += Math.pow(2, exp);
                    exp = 0;
                    tDivisor = divisor;
                }
            }
            if (min && tDividend + 1 == divisor) count++;
            result = count;
            if (negative) {
                result = ~result + 1;
            }
        }
        return result;
    }
}
