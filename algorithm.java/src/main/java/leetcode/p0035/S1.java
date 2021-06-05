package leetcode.p0035;

import java.math.*;
import java.util.*;

public class S1 implements Solution {
    @Override
    public int searchInsert(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (target <= nums[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (target <= nums[l]) {
            return l;
        } else {
            return l + 1;
        }
    }
}
