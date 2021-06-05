package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S3 implements Solution {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = 0;
        List<Integer> list =
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] nums_sorted = new int[len];
        for (int i = 0; i < len; i++) {
            nums_sorted[i] = list.get(i);
        }
        int abc = 0;
        int d = Integer.MAX_VALUE;
        int aa = target / 3 + 1;
        for (int i = 0; i < len - 2; i++) {
            int a = nums_sorted[i];
            if (3 * a > target) {
                int s = a + nums_sorted[i+1] + nums_sorted[i+2];
                if (s - target < d) abc = s;
                break;
            }
            if (a == aa) continue;
            aa = a;
            int bb = a - 1;
            for (int j = i + 1; j < len - 1; j++) {
                int b = nums_sorted[j];
                if (b == bb) continue;
                bb = b;
                int ab = a + b;
                if (2 * a + b > target) {
                    int s = ab + nums_sorted[j+1];
                    int dd = s - target;
                    if (dd < d) {
                        d = dd;
                        abc = s;
                    }
                    break;
                }
                int t = target - ab;
                int l = j + 1, h = len - 1;
                if (nums_sorted[l] == t) {
                    return target;
                } else if (nums_sorted[l] > t) {
                    int dd = nums_sorted[l] - t;
                    if (dd < d) {
                        d = dd;
                        abc = ab + nums_sorted[l];
                    }
                } else if (nums_sorted[h] == t) {
                    return target;
                } else if (nums_sorted[h] < t) {
                    int dd = t - nums_sorted[h];
                    if (dd < d) {
                        d = dd;
                        abc = ab + nums_sorted[h];
                    }
                } else {
                    while (l < h - 1) {
                        int m = l + (h - l) / 2;
                        if (nums_sorted[m] == t) return target;
                        else if (nums_sorted[m] > t) h = m;
                        else l = m;
                    }
                    int dl = t - nums_sorted[l];
                    int dh = nums_sorted[h] - t;
                    if (dl <= dh) {
                        if (dl < d) {
                            d = dl;
                            abc = ab + nums_sorted[l];
                        }
                    } else {
                        if (dh < d) {
                            d = dh;
                            abc = ab + nums_sorted[h];
                        }
                    }
                }
            }
        }
        return abc;
    }

}
