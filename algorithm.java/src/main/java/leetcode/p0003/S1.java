package leetcode.p0003;

import java.util.*;

public class S1 implements Solution {

    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len <= 1) return len;
        int[] dict = new int[256];
        int sub_begin = 1;
        int sub_len = 0;
        int max_sub_len = 0;
        int i = 0;
        while (i < len) {
            int c = s.charAt(i);
            i++;
            if (dict[c] >= sub_begin) {
                sub_len = i - sub_begin;
                if (sub_len > max_sub_len) {
                    max_sub_len = sub_len;
                }
                sub_begin = dict[c] + 1;
            }
            dict[c] = i;
        }
        sub_len = i + 1 - sub_begin;
        if (sub_len > max_sub_len) {
            return sub_len;
        }
        return max_sub_len;
    }

}
