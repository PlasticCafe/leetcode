package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class s0056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int readHead = 1;
        int writeHead = 0;
        while (readHead < intervals.length) {
            if (intervals[writeHead][1] >= intervals[readHead][0]) {
                intervals[writeHead][1] = Math.max(intervals[writeHead][1], intervals[readHead][1]);
            } else {
                writeHead++;
                intervals[writeHead] = intervals[readHead];
            }
            readHead++;
        }
        int[][] result = new int[writeHead + 1][2];
        System.arraycopy(intervals, 0, result, 0, result.length);
        return result;
    }
}
