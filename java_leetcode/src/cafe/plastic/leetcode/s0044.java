package cafe.plastic.leetcode;

import java.util.HashMap;

public class s0044 {
    HashMap<String, Boolean> cache = new HashMap<>();
    public boolean isMatch(String s, String p) {
        p = kleinClean(p);
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else {
            return (p.length() > 0) && match(0, 0, s, p);
        }
    }

    private String kleinClean(String p) {
        if (p.length() == 0) return p;
        StringBuilder output = new StringBuilder();
        String lastChar = "";
        for (int i = 0; i < p.length(); i++) {
            String nextChar = p.substring(i, i + 1);
            if (!(lastChar.equals(nextChar) && lastChar.equals("*"))) {
                lastChar = nextChar;
                output.append(lastChar);
            }
        }
        return output.toString();
    }

    private boolean match(int idxP, int idxS, String s, String p) {
        if (cache.containsKey(idxP + "_" + idxS)) {
            return cache.get(idxP + "_" + idxS);
        }
        if (p.charAt(idxP) == '*') {
            if (idxS >= s.length() - 1) {
                if (idxP == p.length() - 1) {
                     return true;
                } else {
                    boolean res = match(idxP + 1, idxS, s, p);
                    cache.put((idxP + 1) + "_" + idxS, res);
                    return res;
                }
            } else {
                if (idxP == p.length() - 1) {
                    return true;
                } else {
                    boolean res = match(idxP, idxS + 1, s, p);
                    cache.put(idxP + "_" + (idxS + 1), res);
                    if (res) return true;
                    res =  match(idxP + 1, idxS, s, p);
                    cache.put((idxP + 1) + "_" + idxS, res);
                    return res;
                }
            }

        } else if (idxS < s.length() && (p.charAt(idxP) == '?' || s.charAt(idxS) == p.charAt(idxP))){
            if (idxS == s.length() - 1) {
                if (idxP == p.length() - 1) {
                    return true;
                } else {
                    return p.charAt(idxP + 1) == '*' && idxP + 1 == p.length() - 1;
                }
            } else {
                if (idxP == p.length() - 1) {
                    return false;
                } else {
                    int tidxS = idxS;
                    int tidxP = idxP;
                    while (tidxS < s.length() - 1 && tidxP < p.length() - 1) {
                        if (s.charAt(tidxS) == p.charAt(tidxP) || p.charAt(tidxP) == '?') {
                            tidxS++;
                            tidxP++;
                        } else {
                            break;
                        }
                    }
                    boolean res = match(tidxP, tidxS, s, p);
                    cache.put(tidxP + "_" + tidxS, res);
                    return res;
                }
            }
        } else {
            return false;
        }
    }
}
