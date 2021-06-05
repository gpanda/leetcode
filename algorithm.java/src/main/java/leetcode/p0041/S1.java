package leetcode.p0041;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

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
            } else {// out of range, save the last item and shrink range by 1 .
                while (nums[j] == j + 1 && i < j) {
                    j--;
                    // if the last item is already in its value - 1 position
                    // which becomes out of range item, then continue shrink.
                }
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
