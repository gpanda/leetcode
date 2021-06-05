package leetcode.p0044;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false; // null error
        char[] target = s.toCharArray();
        char[] pattern = p.toCharArray();
        // empty pattern
        if (pattern.length == 0) {
            if (target.length == 0) return true;
            else return false;
        }
        // all "*..." pattern
        int i = 0;
        while (i < pattern.length && pattern[i] == '*') i++;
        if (i >= pattern.length) return true;
        // other empty target cases
        if (target.length == 0) return false;
        // normal matching
        i = 0;
        int j = 0;
        int star_pos = -1;
        int tgt_pos = -1;
        while (j < target.length) {
            if (pattern[i] == '*') {
                while (i < pattern.length && pattern[i] == '*') i++;
                if (i == pattern.length) return true; // all "*..." remain
                star_pos = i - 1;
                while (j < target.length &&
                       pattern[i] != '?' && target[j] != pattern[i]) j++;
                if (j == target.length) return false; // tail doesn't match
                i++;
                j++;
                tgt_pos = j;
            /* This two conditional tests can be combined into one
            } else if (pattern[i] == '?') {
                i++;
                j++;
            } else if (pattern[i] == target[j]) {
                i++;
                j++;
            }
            */
            } else if (pattern[i] == '?' || pattern[i] == target[j]) {
                i++; j++;
            } else { // not equal, backtrace to the last star_pos and tgt_pos
                if (star_pos == -1) return false;
                i = star_pos;
                j = tgt_pos;
            }
            if (i == pattern.length && j < target.length) {
                if (star_pos == -1) return false;
                else { // lazy match, backtrace to more greedy
                    i = star_pos;
                    j = tgt_pos;
                }
            }
        }
        // Edited after 1st WA submission, didn't consider "aa" "aa***" case
        while (i < pattern.length && pattern[i] == '*') i++;
        /* this two lines of code can be merged to one
        if (i == pattern.length) return true;
        return false;
        */
        return i == pattern.length;
    }
}
