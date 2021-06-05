package leetcode.p0036;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    @Override
    public boolean isValidSudoku(char[][] board) {
        char[][] rows = new char[9][9];
        char[][] cols = new char[9][9];
        char[][] cubes = new char[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char x = board[r][c];
                if (x == '.') continue;
                int i = x - '1';
                if (rows[r][i] == 1) return false;
                if (cols[c][i] == 1) return false;
                int j = r / 3 * 3 + c / 3;
                if (cubes[j][i] == 1) return false;
                rows[r][i] = 1;
                cols[c][i] = 1;
                cubes[j][i] = 1;
            }
        }
        return true;
    }

}
