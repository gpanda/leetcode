package leetcode.p0005;

import java.util.*;

public class S1 implements Solution {

    @Override
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        char[] cs = new char[len];
        s.getChars(0, len, cs, 0);
        int max_plen = 1;
        int pl = 0;
        int ph = 0;
        for (int t = 0; t < len - (max_plen - 1) / 2 - 1; t++) {
            // 1. single center
            int l = t - 1;
            int h = t + 1;
            while (0 <= l && h < len) {
                if (cs[l] == cs[h]) {
                    l--;
                    h++;
                } else {
                    break;
                }
            }
            int plen = h - l - 1;
            if (plen > max_plen) {
                max_plen = plen;
                pl = l + 1;
                ph = h - 1;
            }
            // 2. double centers
            if (cs[t] == cs[t + 1]) {
                l = t - 1;
                h = t + 2;
                while (0 <= l && h < len) {
                    if (cs[l] == cs[h]) {
                        l--;
                        h++;
                    } else {
                        break;
                    }
                }
                plen = h - l - 1;
                if (plen > max_plen) {
                    max_plen = plen;
                    pl = l + 1;
                    ph = h - 1;
                }
            }
        }
        return s.substring(pl, ph + 1);
    }
}
