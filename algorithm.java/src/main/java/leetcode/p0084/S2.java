package leetcode.p0084;

import java.util.*;

public class S2 implements Solution {
    // Inspired by the best 0ms sample code, and improve the performance
    // of handling many duplicate bars
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return lra(heights, 0, heights.length);
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

/* Test cases
[2,1,5,6,2,3]
[]
[1]
[1,1]
[2,2]
[1,2]
[2,1]
[1,1,1]
[1,2,3]
[3,2,1]
[6,6,4,5,3,3,2,2,1,1,3,1,4]
[1,1,1,3,3,3,3,1,1,1,4,4,4,4,1,1,1,1,3,3,3,3]
[80,1,1,1,3,3,3,3,1,1,1,4,4,4,4,1,1,1,1,3,3,3,3,1,1,1,1,100]
[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
[2,2,2,2,2,2,2,2,2,2,2,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8]
[8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7,7,7,7,7,7,6,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,2,2,2,2,2,2,2,2,2,2,2,2]
*/
