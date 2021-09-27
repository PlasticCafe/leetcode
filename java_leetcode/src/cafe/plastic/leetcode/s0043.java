package cafe.plastic.leetcode;

public class s0043 {

    public String multiply(String num1, String num2) {
        int[] product = multiply(toIntArray(num1), toIntArray(num2));
        return toString(product);
    }

    int[] toIntArray(String num) {
        int[] result = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            result[num.length() - 1 - i] = num.charAt(i) - 48;
        }
        return result;
    }

    String toString(int[] num) {
        int rightBound = num.length - 1;
        while (num[rightBound] == 0 && rightBound > 0) {
            rightBound--;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= rightBound; i++) {
            result.append(num[rightBound - i]);
        }
        return result.toString();
    }

    int[] multiply(int[] num1, int[] num2) {
        int[] result = new int[num1.length*num2.length + 1];
        int carry = 0;
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                int digit = num1[i]*num2[j] + carry;
                result[i + j] +=  digit % 10;
                carry = digit/10;
                if (j == num2.length - 1 && carry != 0) {
                    result[i + j + 1] += carry;
                    carry = 0;
                }
            }
        }
        carry = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] += carry;
            carry = result[i]/10;
            result[i] %= 10;
        }
        return result;
    }

}
