package leetcode.p0045;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    // TLE
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{nums.length - 1, 0});
        int[] bin = null;
        while ((bin = q.poll()) != null) {
            for (int j = bin[0] - 1; j >= 0; j--) {
                if (nums[j] + j >= bin[0]) {
                    if (j == 0) return bin[1] + 1;
                    else q.add(new int[]{j, bin[1] + 1});
                }
            }
        }
        return -1;
    }
}
