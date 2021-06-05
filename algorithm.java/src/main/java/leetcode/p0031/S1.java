package leetcode.p0031;

import java.math.*;
import java.util.*;
import leetcode.libs.*;

public class S1 implements Solution {
    @Override
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        int j = 0;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                j = i - 1;
                break;
            }
            i--;
        }
        if (i == 0) {
            j = nums.length - 1;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
            return;
        }
        while (i < nums.length) {
            if (nums[i] <= nums[j]) {
                break;
            }
            i++;
        }
        int t = nums[j];
        nums[j] = nums[i-1];
        nums[i-1] = t;
        j++;
        i = nums.length - 1;
        while (j < i) {
            t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
            i--;
            j++;
        }

        return;
    }
}
