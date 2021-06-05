package leetcode.p0006;

import java.util.*;

public class S1 implements Solution {

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
        for (int i = 0; i < C; i++) {
            zz[p++] = cs[T * i];
        }
        if (R > 0) {
            zz[p++] = cs[T * C];
        }
        int j;
        for (j = 1; j < numRows - 1; j++) {
            for (int i = 0; i < C; i++) {
                zz[p++] = cs[T * i + j];
                zz[p++] = cs[T * (i + 1) - j];
            }
            if (R > j) {
                zz[p++] = cs[T * C + j];
            }
            if (R > T - j) {
                zz[p++] = cs[T * (C + 1) - j];
            }
       }
       for (int i = 0; i < C; i++) {
           zz[p++] = cs[T * i + j];
       }
       if (R >= numRows) {
           zz[p++] = cs[T * C + j];
       }
       return String.valueOf(zz);
    }
}
