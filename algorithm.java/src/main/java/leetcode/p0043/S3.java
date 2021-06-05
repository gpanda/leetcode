package leetcode.p0043;

import java.util.*;
import java.util.stream.*;

// Runtime beats 99.48% and memory usage beats 95%
public class S3 implements Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        byte[] n1 = num1.getBytes();
        byte[] n2 = num2.getBytes();
        int maxlen = n1.length + n2.length;

        // reverse and normalize >>>
        for (int i = 0, j = n1.length - 1; i <= j; i++, j--) {
            byte t = (byte) (n1[i] - '0');
            n1[i] = (byte) (n1[j] - '0');
            n1[j] = t;
        }
        for (int i = 0, j = n2.length - 1; i <= j; i++, j--) {
            byte t = (byte)(n2[i] - '0');
            n2[i] = (byte)(n2[j] - '0');
            n2[j] = t;
        }
        // reverse and normalize <<<

        // multiply >>>
        // short 2^15 - 1 = 32767 > 110 (digits) * 81 = 8910
        short[] result = new short[maxlen];
        for (int i = 0; i < n1.length; i++) { // only add
            if (n1[i] == 0) continue;
            for (int j = 0; j < n2.length; j++) {
                if (n2[j] == 0) continue;
                result[i+j] += (n1[i] * n2[j]);
            }
        }
        for (int i = 0; i < maxlen; i++) { // linear carry
            if (result[i] > 9) {
                result[i+1] += (result[i] / 10);
                result[i] %= 10;
            }
        }
        // Multiply <<<
        StringBuilder sb = new StringBuilder();
        for (int i = result[maxlen - 1] == 0 ? maxlen - 2 : maxlen - 1;
                 i >= 0; i--)
            sb.append(result[i]);
        return sb.toString();
    }
}
