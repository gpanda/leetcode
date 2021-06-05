package leetcode.p0085;

import java.util.*;

public class S1 implements Solution {
    // TLE
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        return lra(matrix, 0, 0, 0, 0, matrix.length, matrix[0].length);
    }

    private int lra(char[][] matrix, int s1, int s2,
                    int u1, int u2, int b1, int b2) {
        // System.out.println(s1 + "," + s2 + "," + u1 + "," +
                           // u2 + "," + b1 + "," + b2);
        if (u1 == b1 || u2 == b2) return 0;
        boolean broken = false;
        int s2_save = s2;
        for (; s1 < b1; s1++) {
            for(s2 = s2_save; s2 < b2; s2++) {
                if (matrix[s1][s2] == '0') {
                    broken = true;
                    break;
                }
            }
            if (broken) {
                break;
            }
        }
        if (!broken) {
            // System.out.println("No broken:" + (b2-u2)*(b1-u1));
            return (b2 - u2) * (b1 - u1);
        }
        // System.out.println(s1 + "," + s2);
        int max = (b2 - u2) * (s1 - u1);
        // System.out.println("broken:up:" + max);
        int tmp = lra(matrix, s1+1, u2, u1, u2, b1, s2);
        if (tmp > max) {
            max = tmp;
        }
        // System.out.println("after test left:" + tmp);
        tmp = lra(matrix, s1+1, u2, s1+1, u2, b1, b2);
        if (tmp > max) {
            max = tmp;
        }
        // System.out.println("after test bottom:" + tmp);
        tmp = lra(matrix, s1, s2+1, u1, s2+1, b1, b2);
        if (tmp > max) {
            max = tmp;
        }
        // System.out.println("after test right:" + tmp);
        return max;
    }
}
