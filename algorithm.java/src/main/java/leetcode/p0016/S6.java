package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S6 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        List<Integer> list =
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] sorted = new int[len];
        int[] modified = new int[len];
        for (int i = 0; i < len; i++) {
            sorted[i] = list.get(i);
            modified[i] = sorted[i] - target;
        }
        int s = target;
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int a = modified[i];
            int l = i + 1;
            int h = len - 1;
            while (l < h) {
                int b = sorted[l];
                int c = sorted[h];
                int abc = a + b + c;
                if (abc == 0) {
                    return target;
                } else if (abc < 0) {
                    if (-abc < d) {
                        d = -abc;
                        s = abc + target;
                    }
                    l++;
                } else {
                    if (abc < d) {
                        d = abc;
                        s = abc + target;
                    }
                    h--;
                }
            }
        }
        return s;
    }

}
