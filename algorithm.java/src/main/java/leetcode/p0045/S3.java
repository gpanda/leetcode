package leetcode.p0045;

import java.util.*;
import java.util.stream.*;

public class S3 implements Solution {
    // AC and least time usage
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int lastIndex = nums.length - 1;
        int jp = 0;
        int i = 0;
        int j = nums[0];
        if (j >= lastIndex) return 1;
        while(true) {
            jp++;
            int t = -1;
            for (int k = i + 1; k < lastIndex && k <= j; k++) {
                t = java.lang.Math.max(nums[k] + k,  t);
                if (t >= lastIndex) return jp + 1;
            }
            i = j;
            j = t;
        }
    }
}
