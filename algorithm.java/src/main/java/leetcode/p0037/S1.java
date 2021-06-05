package leetcode.p0037;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    @Override
    public void solveSudoku(char[][] board) {
        char[][] rows = new char[9][9];
        char[][] cols = new char[9][9];
        char[][] cubes = new char[9][9];
        // set initial state
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char x = board[r][c];
                if (x == '.') continue;
                int i = x - '1';
                // if (rows[r][i] == 1) return;
                // if (cols[c][i] == 1) return;
                int j = r / 3 * 3 + c / 3;
                // if (cubes[j][i] == 1) return;
                rows[r][i] = 1;
                cols[c][i] = 1;
                cubes[j][i] = 1;
            }
        }
        // solve (backtrace)
        int[][] btable = new int[81][3];
        int t = 0;
        int i = 0;
        int j = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;
                while (i < 9) { // find the next candidate
                    if (rows[r][i] == 0 && cols[c][i] == 0) {
                        j = r / 3 * 3 + c / 3;
                        if (cubes[j][i] == 0) {
                            rows[r][i] = 1;
                            cols[c][i] = 1;
                            cubes[j][i] = 1;
                            btable[t][0] = r;
                            btable[t][1] = c;
                            btable[t][2] = i;
                            t++;
                            i = 0;
                            break;
                        }
                    }
                    i++;
                }
                if (i >= 9) { // if no candidate, backtrace
                    t--;
                    i = btable[t][2];
                    c = btable[t][1];
                    r = btable[t][0];
                    j = r / 3 * 3 + c / 3;
                    cubes[j][i] = 0;
                    cols[c][i] = 0;
                    rows[r][i] = 0;
                    i++;
                    c--;
                }
            }
        }
        while (t-- > 0) {
            board[btable[t][0]][btable[t][1]] = (char) ('1' + btable[t][2]);
        }
        return;
    }

}
