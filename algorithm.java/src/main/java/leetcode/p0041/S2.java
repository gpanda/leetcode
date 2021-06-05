package leetcode.p0041;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {

    @Override
    public int findMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // case 1: missing 1 in the array
        int i = 0;
        while (i < nums.length && nums[i] != 1) i++;
        if (i == nums.length) {
            return 1;
        }
        // case 2: missing the number of k + 1, 1~k exist.
        if (nums.length == 1) {
            return 2;
        }
        nums[i] = nums[0];
        int j = nums.length - 1;
        i = 1;
        while (i < j) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int t = nums[i];
            if (t > i && t <= j + 1
                      && nums[t - 1] != t) {//in range, swap to value - 1 index
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            } else {// out of range, save the last item and shrink range by 1.
                // keep shrinking until the last one is in range
                while (i < j && (nums[j] >= j + 1 || nums[j] <= i)) j--;
                if (i == j) break;
                nums[i] = nums[j];
                j--;
            }
        }
        nums[0] = 1;
        if (nums[i] == i + 1) {
            return i + 2;
        } else {
            return i + 1;
        }
    }
}
