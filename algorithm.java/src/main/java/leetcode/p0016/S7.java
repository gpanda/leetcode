package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S7 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        Arrays.sort(nums);
        int[] sorted = nums;
        int[] modified = new int[len];
        for (int i = 0; i < len; i++) {
            modified[i] = sorted[i] - target;
        }
        int s = target;
        int d = Integer.MAX_VALUE;
        int abc, l, h;
        int aa = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            if (modified[i] == aa) continue;
            aa = modified[i];
            l = i + 1;
            h = len - 1;
            int bb = Integer.MAX_VALUE;
            int cc = Integer.MAX_VALUE;
            while (l < h) {
                abc = modified[i] + sorted[l] + sorted[h];
                if (abc == 0) {
                    return target;
                } else if (abc < 0) {
                    if (-abc < d) {
                        d = -abc;
                        s = abc + target;
                    }
                    l++;
                    while (sorted[l] == bb) l++;
                } else {
                    if (abc < d) {
                        d = abc;
                        s = abc + target;
                    }
                    h--;
                    while (sorted[h] == bb) h--;
                }
            }
        }
        return s;
    }
}
