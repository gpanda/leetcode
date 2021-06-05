package leetcode.p0043;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        byte[] result = new byte[num1.length() + num2.length()];
        byte[] n1 = num1.getBytes();
        byte[] n2 = num2.getBytes();
        for (int i = 0; i < n1.length; i++) n1[i] -= '0'; // !!!
        for (int i = 0; i < n2.length; i++) n2[i] -= '0'; // !!!
        int k = 0;
        for (int i = n1.length - 1; i >= 0; i--) {
            if (n1[i] == 0) continue; // !!!
            for (int j = n2.length - 1; j >=0; j--) {
                if (n2[j] == 0) continue; // !!!
                int m = n1[i] * n2[j];
                k = n1.length - 1 - i + n2.length - 1 - j;
                result[k] += m % 10;
                result[k+1] += m / 10;
                if (result[k] > 9) {
                    result[k] %= 10;
                    result[k+1]++;
                }
                k++;
                while (result[k] > 9) {
                    result[k] %= 10;
                    result[k+1]++;
                    k++;
                }
            }
        }
        if (result[k] == 0) k--;
        StringBuilder sb = new StringBuilder();
        while (k >= 0) {
            sb.append(result[k]);
            k--;
        }
        return sb.toString();
    }
}
