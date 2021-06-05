package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S01 implements Solution {
    public int threeSumClosest(int[] nums, int target) {
        long diff = Long.MAX_VALUE;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                if (sum > target)
                    k--;
                else
                    j++;
                if (Math.abs(sum - (long)target) < diff) {
                    diff = Math.abs(sum - (long)target);
                    res = sum;
                }
            }
        }
        return res;
    }
}
