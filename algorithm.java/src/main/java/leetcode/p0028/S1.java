package leetcode.p0028;

import java.math.*;
import java.util.*;

// My KMP strstr
public class S1 implements Solution {
    @Override
    public int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();
        if (s.length < t.length) {
            return -1;
        }
        int[] k = mykmp_pattern(t);
        int i = 0;
        int j = 0;
        while (j < t.length && s.length - i >= t.length - j) { // !!! >= not >
            if (s[i] != t[j]) {
                j = k[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            } else {
                j++;
                i++;
            }
        }
        if (j < t.length) {
            return -1;
        }
        return i - t.length;
    }

    private int[] mykmp_pattern(char[] t) {
        if (t.length == 0) {
            return null;
        }
        int[] back = new int[t.length];
        back[0] = -1;
        if (t.length > 1) {
            for (int i = 1; i < t.length; i++) {
                int j = back[i - 1];
                while (j >= 0 && t[i - 1] != t[j]) {
                    j = back[j];
                }
                if (j == -1) {
                    back[i] = 0;
                } else {
                    back[i] = j + 1;
                }
            }
        }
        return back;
    }

}
