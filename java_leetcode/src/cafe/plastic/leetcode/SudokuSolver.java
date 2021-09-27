package cafe.plastic.leetcode;

import java.util.*;

public class SudokuSolver {
    List<Set<Integer>> validCols;
    List<Set<Integer>> validRows;
    List<Set<Integer>> validSqrs;
    List<Square> emptySquares;
    char[][] board;

    SudokuSolver(char[][] board) {
        validCols = initList();
        validRows = initList();
        validSqrs = initList();
        this.board = board;
        ingestBoard();
    }

    public void solve() {
        int i = 0;
        Stack<Integer> sequence = new Stack<>();
        while (i < emptySquares.size()) {
            Square next = emptySquares.get(i);
            if (next.currentNum != 0) {
                removeNumber(next.currentNum, next.row, next.col);
            }
            next.currentNum++;
            while (!isValid(next.currentNum, next.row, next.col) && next.currentNum <= 9) {
                next.currentNum++;
            }
            if (next.currentNum > 9) {
                i--;
                next.currentNum = 0;
            } else {
                addNumber(next.currentNum, next.row, next.col);
                i++;
            }
        }

        for (Square square: emptySquares) {
            board[square.row][square.col] = Character.forDigit(square.currentNum, 10);
        }
    }

    List<Set<Integer>> initList() {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<Integer>());
        }
        return list;
    }

    void ingestBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') {
                    emptySquares.add(new Square(row, col));
                } else {
                    addNumber(Character.getNumericValue(board[row][col]), row, col);
                }
            }
        }
    }

    private void addNumber(int num, int row, int col) {
        validRows.get(row).add(num);
        validCols.get(col).add(num);
        validSqrs.get(row / 3 + col / 3 * 3).add(num);
    }

    private void removeNumber(int num, int row, int col) {
        validRows.get(row).remove(num);
        validCols.get(col).remove(num);
        validSqrs.get(row / 3 + col / 3 * 3).remove(num);
    }


    private boolean isValid(int num, int row, int col) {
        return !(validRows.get(row).contains(num) || validCols.get(col).contains(num) || validSqrs.get(row / 3 + col / 3 * 3).contains(num));
    }


    class Square {
        final int row, col;
        int currentNum = 0;

        Square(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
