package cafe.plastic.leetcode;

public class s0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) { return 0;}
        for(int i = 0; i <= haystack.length() - needle.length(); i ++) {
            if (checkAtIndex(i, haystack, needle)) {return i;}
        }
        return -1;
    }

    private boolean checkAtIndex(int index, String haystack, String needle) {
        for(int i = index; i - index < needle.length(); i ++) {
            if(haystack.charAt(i) != needle.charAt(i - index)) {return false;}
        }
        return true;
    }
}
