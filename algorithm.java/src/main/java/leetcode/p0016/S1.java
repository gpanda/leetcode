package leetcode.p0016;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        List<Integer> list =
            // both ok
            // IntStream.of(nums).boxed().collect(Collectors.toList());
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] nums_sorted = new int[len];
        for (int i = 0; i < len; i++) {
            nums_sorted[i] = list.get(i);
        }

        int a, b, c, d, dd, s;
        d = Integer.MAX_VALUE;
        s = 0;
        for (int i = 0; i < len - 2; i++) {
            a = nums_sorted[i];
            for (int j = i + 1; j < len - 1; j++) {
                b = nums_sorted[j];
                for (int k = j + 1; k < len; k++) {
                    c = nums_sorted[k];
                    dd = -target + a + b + c;
                    if (dd < 0) {
                        if (-dd < d) {
                            d = -dd;
                            s = target + dd;
                        }
                    } else {
                        if (dd < d) {
                            d = dd;
                            s = target + dd;
                        }
                    }
                }
            }
        }

        return s;
    }
}
