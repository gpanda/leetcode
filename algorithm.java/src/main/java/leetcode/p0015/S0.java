package leetcode.p0015;

import java.util.*;

public class S0 implements Solution {

    // find all unique (a, b, c) tuples, each of which satisfies a + b + c = 0
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ts = new ArrayList<>();
        if (len == 0) return ts;
        List<Integer> list = new ArrayList<>(len);
        for (int x : nums) list.add(x);
        Collections.sort(list);
        int[] nums_sorted = new int[len];
        int k = 0;
        for (Integer x : list) {
            nums_sorted[k++] = x;
        }
        long map_size = -1;
        int min = nums_sorted[0];
        int max = nums_sorted[len - 1];
        map_size = (long)max - (long)min + 1L;
        if (map_size > Integer.MAX_VALUE) return null;
        int[] map = new int[(int)map_size];
        for (int i = 0; i < len; i++) {
            map[nums_sorted[i] - min] = i + 1;
        }
        int a, b, c, aa, bb;
        long cc;
        aa = 1;
        for (int i = 0; i < len - 2; i++) {
            a = nums_sorted[i];
            if (a > 0) break;
            if (a == aa) continue;
            aa = a;
            bb = a - 1;
            for (int j = i + 1; j < len - 1; j++) {
                b = nums_sorted[j];
                if (b == bb) continue;
                cc = -((long)a + (long)b);
                if (cc < 0L) break;
                if (cc > max) continue;
                bb = b;
                int ic = map[(int)cc - min];
                if(ic - 1 > j) {
                    ts.add(Arrays.asList(a, b, (int)cc));
                }
            }
        }
        return ts;
    }
}
