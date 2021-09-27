package cafe.plastic.leetcode;

public class s0036 {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') continue;
                int num = board[row][col] - 48;
                if ((rows[row] & 1<<num) == 0) {
                    rows[row] |= 1<<num;
                } else {
                    return false;
                }

                if ((columns[col] & 1<<num) == 0) {
                    columns[col] |= 1<<num;
                } else {
                    return false;
                }
                int box = getBox(row, col);

                if (((boxes[box] & 1<<num) == 0)) {
                    boxes[box] |= 1<<num;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    int getBox(int row, int col) {
        return row/3 + col/3 * 3;
    }
}
