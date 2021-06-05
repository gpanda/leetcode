package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S4 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        List<Integer> list =
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] sorted = new int[len];
        int[] minus_t = new int[len];
        for (int i = 0; i < len; i++) {
            sorted[i] = list.get(i);
            minus_t[i] = sorted[i] - target;
        }
        int abc = 0;
        int d = Integer.MAX_VALUE;
        int aa = target / 3 + 1;
        for (int i = 0; i < len - 2; i++) {
            int a = sorted[i];
            if (a * 3 >= target) {
                int dd = a + sorted[i+1] + minus_t[i+2];
                if (dd < d) abc = dd + target;
                break;
            }
            if (a == aa) continue;
            aa = a;
            int bb = a - 1;
            for (int j = i + 1; j < len - 1; j++) {
                int b = sorted[j];
                if (b == bb) continue;
                bb = b;
                int ab = a + b;
                int h = len - 1;
                int l = j + 1;
                int dd = ab + minus_t[l];
                if (ab + a >= target || ab + b >= target || dd >= 0) {
                    if (dd < d) {
                        abc = dd + target;
                        d = dd;
                    }
                    break;
                }
                dd = ab + minus_t[h];
                if (dd <= 0) {
                    if (-dd < d) {
                        abc = dd + target;
                        d = -dd;
                    }
                    continue;
                }
                // find the closest in [j+1, len-1]
                while (h - l > 1) {
                    int m = l + (h - l) / 2;
                    dd = ab + minus_t[m];
                    if (dd == 0) {
                        return target;
                    } else if (dd < 0) {
                        l = m;
                    } else {
                        h = m;
                    }
                }
                int ddh = ab + minus_t[h];
                int ddl = -(ab + minus_t[l]);
                if (ddh < ddl) {
                    if (ddh < d) {
                        abc = ddh + target;
                        d = ddh;
                    }
                } else {
                    if (ddl < d) {
                        abc = -ddl + target;
                        d = ddl;
                    }
                }
            }
        }
        return abc;
    }

}
