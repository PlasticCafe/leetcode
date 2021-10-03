package cafe.plastic.leetcode;

import java.util.*;

public class s0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<ArrayList<Integer>> intervalsList = new ArrayList<>();
        ArrayList<Integer> newIntervalList = new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1]));
        for (int[] interval : intervals) {
            intervalsList.add(new ArrayList<Integer>(Arrays.asList(interval[0], interval[1])));
        }
        int insertIdx = Collections.binarySearch(intervalsList, newIntervalList, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        int writeHead = 0;
        if (insertIdx < 0) {
            writeHead = -1 * (insertIdx + 1);
        } else {
            writeHead = insertIdx;
        }
        intervalsList.add(writeHead, newIntervalList);
        if (writeHead != 0) writeHead--;
        int readHead = writeHead + 1;
        while (readHead < intervalsList.size()) {
            if (intervalsList.get(writeHead).get(1) >= intervalsList.get(readHead).get(0)) {
                intervalsList.get(writeHead).set(1, Math.max(intervalsList.get(writeHead).get(1), intervalsList.get(readHead).get(1)));
            } else {
                writeHead++;
                intervalsList.set(writeHead, intervalsList.get(readHead));
            }
            readHead++;
        }
        intervalsList = intervalsList.subList(0, writeHead + 1);
        int[][] result = new int[intervalsList.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = intervalsList.get(i).get(0);
            result[i][1] = intervalsList.get(i).get(1);
        }
        return result;
    }
}

