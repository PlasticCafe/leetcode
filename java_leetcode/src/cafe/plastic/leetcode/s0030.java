package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s0030 {
    public ArrayList<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        HashMap<String, Counter> wordsMap = new HashMap<>();
        int runningTotal = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int word = 0; word < words.length; word++) {
            if (wordsMap.containsKey(words[word])) {
                wordsMap.get(words[word]).copies++;
            } else {
                wordsMap.put(words[word], new Counter(word, 0, 0, 1));
            }
        }
        for (int i = 0; i < s.length() - words.length * wordLen + 1; i++) {
            runningTotal = 0;
            for (int j = i; runningTotal < words.length; j += wordLen) {
                String testWord = s.substring(j, j + wordLen);
                if (wordsMap.containsKey(testWord)) {
                    Counter counter = wordsMap.get(testWord);
                    if (counter.base != i) {
                        counter.base = i;
                        counter.count = 1;
                    } else if (counter.count >= counter.copies) {
                        break;
                    } else {
                        counter.count++;
                    }
                    runningTotal++;
                } else {
                    break;
                }
            }
            if (runningTotal == words.length) {
                result.add(i);
            }
        }
        return result;
    }
    class Counter {
        int index;
        int base;
        int count;
        int copies;
        Counter(int index, int base, int count, int copies) {
            this.index = index;
            this.base = base;
            this.count = count;
            this.copies = copies;
        }
    }
}
