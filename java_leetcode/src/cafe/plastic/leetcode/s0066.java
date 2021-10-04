package cafe.plastic.leetcode;

public class s0066 {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 && carry; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                carry = false;
            }
        }
        if (!carry) {
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
    }
}
