package cafe.plastic.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class s0065 {
    public boolean isNumber(String s) {
        HashSet<Character> symbols = new HashSet<>(Arrays.asList('+', '-', '.', 'e'));
        HashSet<Character> digits = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        for(int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            symbol = Character.toLowerCase(symbol);
            if(symbols.contains(symbol)) {
                if (symbol == '.') {
                    symbols.remove(symbol);
                    if ((i - 1 < 0 || !digits.contains(s.charAt(i - 1))) && ( i + 1 >= s.length() || (!digits.contains(s.charAt(i+1))))) {
                        return false;
                    } else if (!symbols.contains('e')) {
                        return false;
                    }
                } else if (symbol == 'e') {
                    symbols.remove(symbol);
                    if ( i - 1 < 0 || (!digits.contains(s.charAt(i - 1)) && s.charAt(i - 1) != '.') || i + 1 >= s.length()){
                        return false;
                    }
                }
                else if (i + 1 >= s.length() || (!digits.contains(s.charAt(i + 1)) && s.charAt(i + 1) != '.')) {
                    return false;
                } else if ( i - 1 >= 0 && (s.charAt(i - 1) != 'e')) {
                    return false;
                }
            } else if (!digits.contains(symbol)) {
                return false;
            }
        }
        return true;
    }
}
