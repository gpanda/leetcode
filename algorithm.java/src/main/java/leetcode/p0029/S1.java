package leetcode.p0029;

import java.math.*;
import java.util.*;

public class S1 implements Solution {
    @Override
    public int divide(int dividend, int divisor) {
        // if (divisor == 0) {
        //     throw new ArithmeticException("devide by zero");
        // }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        int sign = 1;
        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            sign = -1;
        }
        int q = 0;
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            dividend += divisor;
            q = 1;
        }
        dividend = Math.abs(dividend);
        if (divisor == 1) {
            return sign == 1 ? dividend : -dividend;
        }
        if (dividend < divisor) {
            return sign == 1 ? q : -q;
        }
        if (divisor == dividend) {
            return sign == 1 ? (1 + q) : -(1 + q);
        }
        int p = divisor;
        int t = dividend;
        while (t >= p) {
            int subq = 1;
            if (p > p << 1) {
                q += subq;
                t -= p;
                continue;
            }
            boolean limit = false;
            p = p << 1;
            while (t >= p) {
                subq = subq << 1;
                if (p > p << 1) {
                    limit = true;
                    break;
                }
                p = p << 1;
            }
            q += subq;
            if (!limit) {
                p = p >> 1;
            } else {
                limit = false;
            }
            t = t - p;
            p = divisor;
        }
        return sign == 1 ? q : -q;
    }

}
