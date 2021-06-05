package leetcode.p0034;

import java.math.*;
import java.util.*;
import leetcode.libs.*;

public class S1 implements Solution {
    @Override
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (target == nums[m]) {
                int h1 = m;
                while (l < h1) {
                    int m1 = l + (h1 - l) / 2;
                    if (target == nums[m1]) {
                        h1 = m1;
                    } else {
                        l = m1 + 1;
                    }
                }
                int l1 = m;
                while (l1 < h) {
                    int m1 = l1 + (h - l1) / 2;
                    if (target == nums[m1]) {
                        if (target == nums[m1 + 1]) {
                            l1 = m1 + 1;
                        } else {
                            h = m1;
                        }
                    } else {
                        h = m1 - 1;
                    }
                }
                return new int[] {l, h};
            } else if (target < nums[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] == target) {
            return new int[] {l, l};
        }
        return new int[] {-1, -1};
    }
}
