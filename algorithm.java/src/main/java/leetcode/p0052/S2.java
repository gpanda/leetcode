package leetcode.p0052;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {
    // best sample answer
    int[] cols, dia1, dia2;
    int count;

    public int totalNQueens(int n) {
        if (n <= 1) { return 1; }
        cols = new int[n]; dia1 = new int[n+n-1]; dia2 = new int[n+n-1];
        for (int i = 1; i < n; i++) { cols[i] = i; }
        recurse(0);
        return count;
    }

    private void recurse(int i) {
        int n = cols.length, m = i==0? (n+1)/2 : n;
        if (i == n) {
            count++;
            if (cols[0] < n/2) {
                count++;
            }
            return;
        }
        int t = cols[i];
        for (int k = i; k < m; k++) {
            int j = cols[k], d1 = i+j, d2 = n-1+i-j;
            if (dia1[d1] == 0 && dia2[d2] == 0) {
                cols[i] = j; cols[k] = t;
                dia1[d1]++; dia2[d2]++;
                recurse(i+1);
                dia1[d1]--; dia2[d2]--;
                cols[k] = j;
            }
        }
        cols[i] = t;
    }
}

