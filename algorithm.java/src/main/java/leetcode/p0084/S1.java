package leetcode.p0084;

import java.util.*;

public class S1 implements Solution {
    public int largestRectangleArea(int[] heights) {
        // left[i] = max{ k | heights[k] < height[i] }
        int[] left = new int[heights.length];
        // right[i] = min{ k | heights[k] < height[i] }
        int[] right = new int[heights.length];
        // range(i): ( left[i], right[i] )

        for (int i = 0; i < heights.length; i++) { // find left radius
            int k = i - 1;
            while (k >= 0 && heights[k] >= heights[i]) k = left[k];
            left[i] = k;
        }
        for (int i = heights.length - 1; i >= 0; i--) { // find right radius
            int k = i + 1;
            while (k < heights.length && heights[k] >= heights[i]) k = right[k];
            right[i] = k;
        }
        int lra = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i > 0 && heights[i] == heights[i-1]) continue;
            lra = Math.max(lra, heights[i] * (right[i] - left[i] - 1));
        }
        return lra;
    }
}
