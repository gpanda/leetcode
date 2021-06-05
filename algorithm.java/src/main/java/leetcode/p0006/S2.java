package leetcode.p0006;

import java.util.*;

public class S2 implements Solution {

    @Override
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows > s.length()) {
            return s;
        }
        char[] cs = s.toCharArray();
        char[] zz = new char[cs.length];
        int T = 2 * numRows - 2;
        int C = cs.length / T;
        int R = cs.length % T;
        int p = 0;
        int q = 0;
        for (int i = 0; i < C; i++, q+=T) {
            zz[p++] = cs[q];
        }
        if (R > 0) {
            zz[p++] = cs[q];
        }
        int j;
        for (j = 1; j < numRows - 1; j++) {
            q = 0;
            for (int i = 0; i < C; i++) {
                zz[p++] = cs[q + j];
                q += T;
                zz[p++] = cs[q - j];
            }
            if (R > j) {
                zz[p++] = cs[q + j];
                q += T;
            }
            if (R > T - j) {
                zz[p++] = cs[q - j];
            }
       }
       q = 0;
       for (int i = 0; i < C; i++) {
           zz[p++] = cs[q + j];
           q += T;
       }
       if (R >= numRows) {
           zz[p++] = cs[q + j];
       }
       return String.valueOf(zz);
    }
}
