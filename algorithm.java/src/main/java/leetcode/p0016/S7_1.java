package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S7_1 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        Arrays.sort(nums);
        int[] modified = new int[len];
        int ilen = len - 2;
        for (int i = 0; i < ilen; i++) {
            modified[i] = nums[i] - target;
        }
        int s = target;
        int d = Integer.MAX_VALUE;
        int dd, l, h, b, c;
        int ma = Integer.MAX_VALUE;
        for (int i = 0; i < ilen; i++) {
            if (nums[i] * 3 >= target) {
                dd = modified[i] + nums[i+1] + nums[i+2];
                if (dd < d) {
                    return dd + target;
                } else {
                    return s;
                }
            }
            if (modified[i] == ma) continue;
            ma = modified[i];
            l = i + 1;
            h = len - 1;
            while (l < h) {
                b = nums[l];
                c = nums[h];
                dd = ma + b + c;
                if (dd == 0) {
                    return target;
                } else if (dd < 0) {
                    if (-dd < d) {
                        d = -dd;
                        s = dd + target;
                    }
                    l++;
                    while (nums[l] == b) {
                        l++;
                        if (l >= h) break;
                    }
                } else {
                    if (dd < d) {
                        d = dd;
                        s = dd + target;
                    }
                    h--;
                    while (nums[h] == c) {
                        h--;
                        if (h <= l) break;
                    }
                }
            }
        }
        return s;
    }

}
