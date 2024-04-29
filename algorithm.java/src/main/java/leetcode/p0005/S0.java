package leetcode.p0005;

import java.util.*;
import java.lang.*;

public class S0 implements Solution {

    @Override
    public String longestPalindrome(String s) {
        if (s.length() <=1) return s;
        String r = "";
        int len = 0;
        int[][] conn = new int[s.length()][2];
        for (int i = 0, j = i+1; i < s.length(); i = j, j++) {
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            for (int k = i; k < j; k++) {
                conn[k][0] = i;
                conn[k][1] = j; // exclusive
            }
        }
        int i = 0;
        while(i < s.length()) {
            int ll = i;
            int rl = s.length() - i - 1;
            int arm = Math.min(ll, rl);
            if (arm * 2 + 1 <= len) break;
            int h = conn[i][0]-1;
            int t = conn[i][1];
            while (h >= 0 && t < s.length() && s.charAt(h) == s.charAt(t)) {
                arm = Math.min(conn[h][1]-conn[h][0],conn[t][1]-conn[t][0]);
                h-=arm;
                t+=arm;
            }
            if (t - h - 1 > len) {
                r = s.substring(h+1, t);
                len = r.length();
            }
            i = conn[i][1];
        }
        return r;
    }
}

// vim: tw=78:ts=8:sts=4:sw=4:et:ft=java:norl:
