package leetcode.p0084;

import java.util.*;

public class SS1 implements Solution {
    // SAMPLE BEST EFFCIENCY CODE ON LEETCODE
    public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		return sub(heights, 0, heights.length - 1);
	}

	private int sub(int[] heights, int start, int end) {
		if (start > end)
			return 0;
		if (start == end)
			return heights[start];

		int max = 0;
		boolean asc = true;
		boolean desc = true;
		int min = heights[start];
		for (int i = start + 1; i <= end; i++) {
			if (heights[i] < min)
				min = heights[i];
			if (heights[i] < heights[i - 1])
				asc = false;
			if (heights[i] > heights[i - 1])
				desc = false;
		}

        // if keep ascending
		if (asc) {
			max = heights[end];
			for (int i = end - 1; i >= start; i--) {
				int sum = (end - i + 1) * heights[i];
				if (sum > max)
					max = sum;
			}
			return max;
		}
        // or keep descending
		if (desc) {
			max = heights[start];
			for (int i = start + 1; i <= end; i++) {
				int sum = (i - start + 1) * heights[i];
				if (sum > max)
					max = sum;
			}
			return max;
		}

		int substart = start;
		int submax = 0;
		max = min * (end - start + 1); // at least min bar * number of bars
		for (int i = start; i <= end; i++) {
			if (heights[i] == min) {
                // get max of left side of min bar
				submax = sub(heights, substart, i - 1);
				max = submax > max ? submax : max;
				substart = i + 1;
			}
		}
        // get max of right side of min bar
		submax = sub(heights, substart, end);
		max = submax > max ? submax : max;

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
*/
