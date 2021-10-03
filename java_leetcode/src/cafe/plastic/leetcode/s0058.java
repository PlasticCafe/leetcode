package cafe.plastic.leetcode;

public class s0058 {
    public int lengthOfLastWord(String s) {
        boolean countStart = false;
        int count = 0;
        for(int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (countStart) break;
            } else {
                countStart = true;
                count++;
            }
        }
        return count;
    }
}
