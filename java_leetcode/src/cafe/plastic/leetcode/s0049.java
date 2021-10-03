package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class s0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> indexMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String canon = canonicalize(strs[i]);
            if (indexMap.containsKey(canon)) {
                List<Integer> indexArray = indexMap.get(canon);
                indexArray.add(i);
            } else {
                ArrayList<Integer> indexArray = new ArrayList<>();
                indexArray.add(i);
                indexMap.put(canon, indexArray);
            }
        }
        for (ArrayList<Integer> array: indexMap.values()) {
            ArrayList<String> group = new ArrayList<>();
            for (int strIndex: array) {
                group.add(strs[strIndex]);
            }
            anagrams.add(group);
        }
        return anagrams;
    }

    public String canonicalize(String str) {
        char[] charStr = str.toCharArray();
        Arrays.sort(charStr);
        return new String(charStr);
    }
}
