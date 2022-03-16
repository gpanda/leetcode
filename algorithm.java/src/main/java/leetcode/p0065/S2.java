package leetcode.p0065;

import java.util.*;

class S2 implements Solution {
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
    private static final int ERROR = -1;
    private static final int FINAL = 0;
    public boolean isNumber(String s) {
        if (s == null) return false;
        return sm_start(s, 0) == FINAL;
    }

    private int sm_start(String s, int idx) {
        if (idx >= s.length()) return ERROR; // non-terminal
        char c = s.charAt(idx);
        if (c == '+' || c == '-') {
            idx++;
        }
        return state_1(s, idx);
    }

    private int state_1(String s, int idx) {
        if (idx >= s.length()) return ERROR; // non-terminal
        char c = s.charAt(idx);
        if (c == '.') {
            idx++;
            return state_2(s, idx);
        } else if (isDigit(c)) {
            idx++;
            return state_7(s, idx);
        } else {
            return ERROR;
        }
    }

    private int state_2(String s, int idx) {
        if (idx >= s.length()) return ERROR; // non-terminal
        char c = s.charAt(idx);
        if (isDigit(c)) {
            idx++;
            return state_3(s, idx);
        }  else {
            return ERROR;
        }
    }

    private int state_3(String s, int idx) {
        char c = 0;
        while (idx < s.length() && isDigit(s.charAt(idx))) idx++;
        if (idx >= s.length()) return FINAL; // terminal
        c = s.charAt(idx);
        if (c == 'E' || c == 'e') {
            idx++;
            return state_4(s, idx);
        } else {
            return ERROR;
        }
    }

    private int state_4(String s, int idx) {
        if (idx >= s.length()) return ERROR; // non-terminal
        char c = s.charAt(idx);
        if (c == '+' || c == '-') {
            idx++;
        }
        return state_5(s, idx);
    }

    private int state_5(String s, int idx) {
        if (idx >= s.length()) return ERROR; // non-terminal
        char c = s.charAt(idx);
        if (isDigit(c)) {
            idx++;
            return state_6(s, idx);
        } else {
            return ERROR;
        }
    }

    private int state_6(String s, int idx) {
        while (idx < s.length() && isDigit(s.charAt(idx))) idx++;
        if (idx >= s.length()) {
            return FINAL; // terminal
        } else {
            return ERROR;
        }
    }

    private int state_7(String s, int idx) {
        char c = 0;
        while (idx < s.length() && isDigit(s.charAt(idx))) idx++;
        if (idx >= s.length()) return FINAL; // terminal
        c = s.charAt(idx);
        if (c == '.') {
            idx++;
            return state_3(s, idx);
        } else if (c == 'E' || c == 'e') {
            idx++;
            return state_4(s, idx);
        } else {
            return ERROR;
        }
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
