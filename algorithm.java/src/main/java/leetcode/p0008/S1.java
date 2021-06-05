package leetcode.p0008;

import java.util.*;

public class S1 implements Solution {

    @Override
    public int myAtoi(String str) {
        char[] cs = str.trim().toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        int sign = 1;
        int i = 0;
        if (cs[0] == '-') {
            sign = -1;
            i++;
        }
        if (cs[0] == '+') {
            i++;
        }
        int result = 0;
        while (i < cs.length) {
            if (cs[i] < '0' || cs[i] > '9') {
                break;
            }
            int new_result = result * 10 + (cs[i] - '0');
            if (new_result / 10 != result) {
                if (sign == 1) {
                    return 2147483647;
                } else {
                    return -2147483648;
                }
            }
            result = new_result;
            i++;
        }
        return sign * result;
    }
}
