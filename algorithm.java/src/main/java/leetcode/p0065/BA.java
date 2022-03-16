package leetcode.p0065;

import java.util.*;

class BA implements Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '-' || c =='+') {
                if (i != 0 && !isExponent(s.charAt(i - 1))) {
                    return false;
                }
            } else if (c == '.') {
                if (seenExponent || seenDot) {
                    return false;
                }
                seenDot = true;
            } else if (isExponent(c)) {
                if (seenExponent || !seenDigit ) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else {
                return false;
            }
        }

        return seenDigit;
    }

    private boolean isExponent(char c) {
        return c == 'e' || c == 'E';
    }
}
