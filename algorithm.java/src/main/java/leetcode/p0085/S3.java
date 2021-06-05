package leetcode.p0085;

import java.util.*;

public class S3 implements Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0, n = matrix[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            max = Math.max(max, lra(heights, 0, n));
        }
        return max;
    }

    private int lra(int[] heights, int start, int end) {
        if (end - start == 1) {
            return heights[start];
        }
        // 1. find the min bar, compute basis max by min * heights.length
        boolean ascd = true;
        boolean desc = true;
        int min = heights[start];
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
            if (heights[i] < heights[i-1]) {
                ascd = false;
            } else if (heights[i] > heights[i-1]) {
                desc = false;
            }
        }
        int max = min * (end - start);
        // 2. divide the histogram into several hills, each of which is
        // separated by 2 min bars as (start - 1) and (end), i.e. the range of
        // each hill is [start, end).
        if (ascd) { // only one ascending hill
            for (int i = start + 1; i < end; i++) {
                if (heights[i] == heights[i-1]) continue;
                int tmp = heights[i] * (end - i);
                if (tmp > max) {
                    max = tmp;
                }
            }
        } else if (desc) { // only one descending hill
            for (int i = end - 2; i >= start; i--) {
                if (heights[i] == heights[i+1]) continue;
                int tmp = heights[i] * (i - start + 1);
                if (tmp > max) {
                    max = tmp;
                }
            }
        } else { // divide and conquer each hill
            boolean getStart = false;
            for (int i = start; i < end; i++) {
                if (!getStart) {
                    if (heights[i] == min) continue;
                    start = i;
                    getStart = true;
                } else {
                    if (heights[i] != min) continue;
                    int tmp = lra(heights, start, i);
                    if (tmp > max) {
                        max = tmp;
                    }
                    getStart = false;
                }
            }
            if (getStart) { // the rightmost hill
                int tmp = lra(heights, start, end);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

}
