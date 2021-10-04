package cafe.plastic.leetcode;

public class s0067 {
    public String addBinary(String a, String b) {
        String top = a.length() > b.length() ? a : b;
        String bottom = a.length() > b.length() ? b: a;
        int topHead = top.length() - 1;
        int botHead = bottom.length() - 1;
        boolean carry = false;
        StringBuilder result = new StringBuilder();
        while(true) {
            if(botHead >= 0) {
                if (top.charAt(topHead) == '1' && bottom.charAt(botHead) == '1') {
                    if (carry) {
                        result.append("1");
                    } else {
                        result.append("0");
                        carry = true;
                    }
                } else if (top.charAt(topHead) == '0' && bottom.charAt(botHead) == '0') {
                    if (carry) {
                        result.append("1");
                        carry = false;
                    } else {
                        result.append("0");
                    }
                } else {
                    if (carry) {
                        result.append("0");
                    } else {
                        result.append("1");
                    }
                }
                topHead--;
                botHead--;
            } else if (topHead >= 0) {
                if (top.charAt(topHead) == '1') {
                    if (carry) {
                        result.append("0");
                    } else{
                        result.append("1");
                    }
                } else{
                    if (carry) {
                        result.append("1");
                        carry = false;
                    } else {
                        result.append("0");
                    }
                }
                topHead--;
            } else {
                break;
            }
        }
        if (carry) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
