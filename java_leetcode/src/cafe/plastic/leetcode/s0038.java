package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class s0038 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            ArrayList<Segment> segments = new ArrayList<>();
            String said = countAndSay(n - 1);
            for (int i = 0; i < said.length(); i++) {
                if (!segments.isEmpty()) {
                    if (segments.get(segments.size() - 1).character == said.charAt(i)) {
                        segments.get(segments.size() - 1).count++;
                        continue;
                    }
                }
                segments.add(new Segment(said.charAt(i), 1));
            }
            StringBuilder output = new StringBuilder();
            for (Segment segment: segments) {
                output.append(segment.count).append(segment.character);
            }
            return output.toString();
        }
    }

    class Segment {
        char character;
        int count;
        Segment(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}
