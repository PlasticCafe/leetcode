package cafe.plastic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class s0059 {
    int count = 1;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int mStart = 0;
        int mEnd = n - 1;
        int nStart = 0;
        int nEnd = n - 1;

        while (mStart <= mEnd && nStart <= nEnd) {
            arrayLerp(mStart, mStart++, nStart, nEnd, matrix);
            if (mStart > mEnd) break;
            arrayLerp(mStart, mEnd, nEnd, nEnd--, matrix);
            if (nStart > nEnd) break;
            arrayLerp(mEnd, mEnd--, nEnd, nStart, matrix);
            if (mStart > mEnd) break;
            arrayLerp(mEnd, mStart, nStart, nStart++, matrix);
        }
        return matrix;
    }

    private void arrayLerp(int iStart, int iEnd, int jStart, int jEnd, int[][] array) {
        int steps = iEnd - iStart == 0 ?  jEnd - jStart : iEnd - iStart;
        int sign = steps < 0 ? -1 : 1;
        steps = sign * steps;
        for(int i = 0; i <= steps; i++) {
            if (iEnd - iStart != 0) {
                array[iStart + i * sign][jStart] = count++;
            } else {
                array[iStart][jStart + i*sign] = count++;
            }
        }
    }
}
