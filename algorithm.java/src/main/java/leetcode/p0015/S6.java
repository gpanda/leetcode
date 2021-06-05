package leetcode.p0015;

import java.util.*;

public class S6 implements Solution {

    // find all unique (a, b, c) tuples, each of which satisfies a + b + c = 0
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ts = new ArrayList<>();
        if (len == 0) return ts;
        List<Integer> list = new ArrayList<>(len);
        for (int x : nums) list.add(x);
        Collections.sort(list);
        long map_size = -1;
        int min = list.get(0);
        int max = list.get(list.size() - 1);
        map_size = (long)max - (long)min + 1L;
        if (map_size > Integer.MAX_VALUE) return null;
        int[] map = new int[(int)map_size];
        for (int i = 0; i < len; i++) {
            map[list.get(i) - min] = i + 1;
        }
        int a, b, c, aa, bb;
        aa = 1; // a must be <= 0
        for (int i = 0; i < len - 2; i++) {
            a = list.get(i);
            if (a > 0) break;
            if (a == aa) continue;
            aa = a;
            bb = a - 1;
            for (int j = i + 1; j < len - 1; j++) {
                b = list.get(j);
                if ((long)a + (long)b > 0L) break;
                if ((long)a + (long)b < -max) continue;
                if (b == bb) continue;
                bb = b;
                c = -a - b;
                int ic = map[c - min];
                if(ic - 1 > j) {
                    ts.add(Arrays.asList(a, b, c));
                }
            }
        }
        return ts;
    }
}
