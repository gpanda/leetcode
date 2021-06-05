package leetcode.p0072;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] t = new int[l1+1][l2+1];
        for (int i = 1; i <= Math.min(l1, l2); i++) t[i][i] = -1;
        int d = wagner_fischer(word1, word2, l1, l2, t);
        return d;
    }

    private int wagner_fischer(String w1, String w2, int i, int j, int[][] t) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (i == j) {
            if (t[i][j] != -1) return t[i][j];
        } else {
            if (t[i][j] > 0) return t[i][j];
        }
        int d = 0;
        if (w1.charAt(i-1) == w2.charAt(j-1)) {
            d = wagner_fischer(w1, w2, i-1, j-1, t);
            t[i][j] = d;
            return d;
        }
        int d1 = wagner_fischer(w1, w2, i-1, j-1, t);
        int d2 = wagner_fischer(w1, w2, i-1, j, t);
        int d3 = wagner_fischer(w1, w2, i, j-1, t);
        d = Math.min(d1, d2);
        d = Math.min(d, d3) + 1;
        t[i][j] = d;
        return d;
    }
}

