package leetcode.p0033;

import java.math.*;
import java.util.*;
import leetcode.libs.*;

public class S1 implements Solution {
    @Override
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        if (target >= nums[0]) { // search the 1st section
            int m;
            while (l < h) {
                m = l + (h - l) / 2;
                if (nums[m] >= nums[l]) {
                    if (target == nums[m]) {
                        return m;
                    } else if (target < nums[m]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    h = m - 1;
                }
            }
        } else {
            int m;
            while (l < h) { // search the 2nd section
                m = l + (h - l) / 2;
                if (nums[m] <= nums[h]) {
                    if (target == nums[m]) {
                        return m;
                    } else if (target < nums[m]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    l = m + 1;
                }
            }
        }
        if (target == nums[l]) {
            return l;
        }

        return -1;
    }
}
