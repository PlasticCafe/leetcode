package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class s0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)  return result;
        int n = matrix[0].length;

        int mStart = 0;
        int mEnd = m - 1;
        int nStart = 0;
        int nEnd = n - 1;

        while (mStart <= mEnd && nStart <= nEnd) {
            arrayLerp(mStart, mStart++, nStart, nEnd, matrix, result);
            if (mStart > mEnd) break;
            arrayLerp(mStart, mEnd, nEnd, nEnd--, matrix, result);
            if (nStart > nEnd) break;
            arrayLerp(mEnd, mEnd--, nEnd, nStart, matrix, result);
            if (mStart > mEnd) break;
            arrayLerp(mEnd, mStart, nStart, nStart++, matrix, result);
        }
        return result;
    }

    private void arrayLerp(int iStart, int iEnd, int jStart, int jEnd, int[][] array, List<Integer> output) {
        int steps = iEnd - iStart == 0 ?  jEnd - jStart : iEnd - iStart;
        int sign = steps < 0 ? -1 : 1;
        steps = sign * steps;
        for(int i = 0; i <= steps; i++) {
            if (iEnd - iStart != 0) {
                output.add(array[iStart + i * sign][jStart]);
            } else {
                output.add(array[iStart][jStart + i*sign]);
            }
        }
    }
}
