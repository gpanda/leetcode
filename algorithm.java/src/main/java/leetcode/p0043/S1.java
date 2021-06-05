package leetcode.p0043;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        byte[] result = new byte[num1.length() + num2.length()];
        int k = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >=0; j--) {
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                k = num1.length() - 1 - i + num2.length() - 1 - j;
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
            sb.append((char)(result[k] +'0'));
            k--;
        }
        return sb.toString();
    }
}
