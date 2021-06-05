package leetcode.p0005;

import java.util.*;

public class S3 implements Solution {

    private char[] cs;
    private int len;
    private int lend;
    private int maxlen = 0;

    @Override
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        cs = s.toCharArray();
        len = cs.length;
        int i = len / 2;
        int j = i - 1;
        if (len % 2 == 1) {
            get_palindrome(i, true);
            get_palindrome(i, false);
            i++;
        }
        while (j >= maxlen / 2) {
            get_palindrome(i, true);
            get_palindrome(i, false);
            get_palindrome(j, true);
            get_palindrome(j, false);
            i++;
            j--;
        }
        return s.substring(lend, lend + maxlen);
    }

    private void get_palindrome(int t, boolean single) {
        int h = t + 1;
        if (!single) {
            if (t >= len - 1 || cs[t] != cs[t+1]) {
                return;
            }
            h++;
        }
        int l = t - 1;
        while (0 <= l && h < len) {
            if (cs[l] != cs[h]) {
                break;
            }
            l--;
            h++;
        }
        int plen = h - l - 1;
        if (plen > maxlen) {
            maxlen = plen;
            lend = ++l;
        }
    }
}
