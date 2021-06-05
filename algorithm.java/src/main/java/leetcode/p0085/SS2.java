package leetcode.p0085;

import java.util.*;

public class SS2 implements Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n +1];
        int res = 0;
        for (int row = 0; row < m; row++) {
            updateHeights(matrix, row, heights);
            res = Math.max(res, maxArea(heights));
        }
        return res;
    }

    private void updateHeights(char[][] matrix, int row, int[] heights) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[row][col] == '1') {
                heights[col]++;
            } else {
                heights[col] = 0;
            }
        }
    }

    private int maxArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int l = 0;
        stack[l] = -1;
        int res = 0;
        for (int r = 0; r < n; r++) {
            while (l > 0 && heights[r] < heights[stack[l]]) {
                int h = heights[stack[l--]];
                res = Math.max(res, h * (r - stack[l] - 1));
            }
            stack[++l] = r;
        }
        return res;
    }
}
