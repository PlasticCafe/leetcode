package cafe.plastic.leetcode;

import static org.junit.jupiter.api.Assertions.*;

class s1275Test {

    @org.junit.jupiter.api.Test
    void tictactoe() {
        int[][] input = {{0,0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        s1275 ticTacToe = new s1275();
        assertEquals("A", ticTacToe.tictactoe(input));
    }
}