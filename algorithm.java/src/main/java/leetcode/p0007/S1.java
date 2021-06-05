package leetcode.p0007;

import java.util.*;

public class S1 implements Solution {

    @Override
    public int reverse(int x) {
        int sign = 1;
        if (x == -2147483648) {
            return 0;
        }
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > 2147483647) {
            return 0;
        }
        return sign * (int) result;
    }
}
