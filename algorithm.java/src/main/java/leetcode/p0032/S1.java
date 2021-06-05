package leetcode.p0032;

import java.math.*;
import java.util.*;
import leetcode.libs.*;

public class S1 implements Solution {
    @Override
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int[] sep_stack = new int[cs.length + 1];
        int sp = 0;
        int csp = 0;
        int i = 0;
        int len = 0;
        int max_len = 0;
        sep_stack[sp++] = -1;
        while (i < cs.length) {
            if (cs[i] == '(') {
                csp++;
                sep_stack[sp++] = i;
            } else { // ')'
                if (csp == 0) { // invalid
                    len = i - sep_stack[--sp] - 1; // sp:1->0
                    if (len > max_len) {
                        max_len = len;
                    }
                    sep_stack[sp++] = i; // sp:0->1
                } else {
                    csp--;
                    sp--;
                }
            }
            i++;
        }
        while (csp > 0) {
            len = i - sep_stack[--sp] - 1;
            if (len > max_len) {
                max_len = len;
            }
            i = sep_stack[sp];
            csp--;
        }
        if (sp == 1) {
            len = i - sep_stack[--sp] - 1; // sp == 0
            if (len > max_len) {
                max_len = len;
            }
        }
        return max_len;
    }
}
