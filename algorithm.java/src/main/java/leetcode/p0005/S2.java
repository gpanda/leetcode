package leetcode.p0005;

import java.util.*;

public class S2 implements Solution {

    private int[] ends = new int[2];
    private int maxlen = 0;

    @Override
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        char[] cs = new char[len];
        s.getChars(0, len, cs, 0);
        int i = len / 2;
        int j = i - 1;
        if (len % 2 == 1) {
            get_palindrome(cs, i, true);
            get_palindrome(cs, i, false);
            i++;
        }
        while (j >= maxlen / 2) {
            get_palindrome(cs, i, true);
            get_palindrome(cs, i, false);
            get_palindrome(cs, j, true);
            get_palindrome(cs, j, false);
            i++;
            j--;
        }
        return s.substring(ends[0], ends[1] + 1);
    }

    private void get_palindrome(char[] cs, int t, boolean single) {
        int h = t + 1;
        if (!single) {
            if (t >= cs.length - 1 || cs[t] != cs[t+1]) {
                return;
            }
            h++;
        }
        int l = t - 1;
        while (0 <= l && h < cs.length) {
            if (cs[l] != cs[h]) {
                break;
            }
            l--;
            h++;
        }
        int plen = h - l - 1;
        if (plen > maxlen) {
            maxlen = plen;
            ends[0] = ++l;
            ends[1] = --h;
        }
    }
}
