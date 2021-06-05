package leetcode.p0016;

import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {

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
        int min = nums_sorted[0];
        int max = nums_sorted[len - 1];

        int a, b, c, aa, bb, cc, d, dd, s, ss;
        d = Integer.MAX_VALUE;
        aa = target / 3 + 1;
        s = 0;
        for (int i = 0; i < len - 2; i++) {
            a = nums_sorted[i];
            if (3 * a >= target) {
                ss = nums_sorted[i] + nums_sorted[i+1] + nums_sorted[i+2];
                dd = ss - target;
                dd = dd >= 0 ? dd : -dd;
                if (dd < d) {
                    return ss;
                }
                break;
            }
            if (a == aa) continue;
            aa = a;
            bb = aa - 1;
            for (int j = i + 1; j < len - 1; j++) {
                b = nums_sorted[j];
                if (2 * a + b >= target) {
                    ss = a + b + nums_sorted[j+1];
                    dd = ss - target;
                    dd = dd >= 0 ? dd : -dd;
                    if (dd < d) {
                        d = dd;
                        s = ss;
                    }
                    break;
                }
                if (b == bb) continue;
                bb = b;
                int r = search_closest(
                    nums_sorted, j + 1, len - 1, target - a - b);
                if (r == -1) {
                    System.exit(-1);
                }
                ss = a + b + nums_sorted[r];
                dd = ss - target;
                dd = dd >= 0 ? dd : -dd;
                if (dd < d) {
                    d = dd;
                    s = ss;
                }
            }
        }
        return s;
    }

    // return the index of the element which is closet to t
    int search_closest(int[] nums_sorted, int i, int j, int t) {
        if (i > j) return -1;
        if (i == j) return i;
        if (t <= nums_sorted[i]) return i;
        if (t >= nums_sorted[j]) return j;
        while (j - i > 1) {
            int m = i + (j - i) / 2;
            if (nums_sorted[m] == t) {
                return m;
            } else if (nums_sorted[m] > t) {
                j = m;
            } else {
                i = m;
            }
        }
        int di = nums_sorted[i] - t;
        di = di >= 0 ? di : -di;
        int dj = nums_sorted[j] - t;
        dj = dj >= 0 ? dj : -dj;
        if (di <= dj) {
            return i;
        } else {
            return j;
        }
    }
}
