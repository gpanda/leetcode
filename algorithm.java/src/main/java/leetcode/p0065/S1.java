package leetcode.p0065;

import java.util.*;

class S1 implements Solution {
/*
    <number> ::= <decimal-number> "e" <integer> |
                 <decimal-number> "E" <integer> |
                 <decimal-number> |
                 <integer> "e" <integer> |
                 <integer> "E" <integer> |
                 <integer>
    <decimal-number> ::=  "+" <absolute-decimal-number> |
                          "-" <absolute-decimal-number> |
                          <absolute-decimal-number>
    <absolute-decimal-number> ::= "." <digits> |
                <digits> "." <digits> |
                <digits> "."
    <integer> ::= "+" <digits> |
                  "-" <digits> |
                  <digits>
    <digits> ::= <digit> | <digit> <digits>
    <digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
*/
    public boolean isNumber(String s) {
        int idx = 0;
        if (s.equals("abc")) {
            int a = 0;
        }
        if ((idx = getDecimal(s, 0)) > 0) {
            if (idx == s.length()) return true;
            if (s.charAt(idx) == 'E' || s.charAt(idx) == 'e') {
                idx++;
                if ((idx = getInteger(s, idx)) < 0) return false;
            }
        } else if ((idx = getInteger(s, 0)) > 0) {
            if (idx == s.length()) return true;
            if (s.charAt(idx) == 'E' || s.charAt(idx) == 'e') {
                idx++;
                if ((idx = getInteger(s, idx)) < 0) return false;
            }
        } else {
            return false;
        }
        if (idx == s.length()) {
            return true;
        } else {
            return false;
        }
    }

    int getDecimal(String s, int idx) {
        if (idx >= s.length()) return -1;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') idx++;
        if (s.charAt(idx) == '.') { // "." <digits>
            idx++;
            return getDigits(s, idx);
        } else {
            idx = getDigits(s, idx);
            if (idx < 0 || idx >= s.length() || s.charAt(idx) != '.') return -1;
            idx++;
            int idx1 = getDigits(s, idx);
            if (idx1 < 0) { // <digits> "."
                return idx;
            } else { // <digits> "." <digits>
                return idx1;
            }
        }
    }

    int getInteger(String s, int idx) {
        if (idx >= s.length()) return -1;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') idx++;
        return getDigits(s, idx);
    }

    int getDigits(String s, int idx) {
        int save = idx;
        while (idx < s.length() && isDigit(s.charAt(idx))) idx++;
        if (idx == save) {
            return -1;
        }
        return idx;
    }

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
