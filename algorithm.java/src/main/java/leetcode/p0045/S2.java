package leetcode.p0045;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {
    // AC, but still not fast enough, rank 66%
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int lastIndex = nums.length - 1;
        int jp = 0;
        int i = 0;
        while (i < lastIndex) {
            if (nums[i] + i >= lastIndex) {
                lastIndex = i;
                i = 0;
                jp++;
            } else {
                i++;
            }
        }
        return jp;
    }
}
