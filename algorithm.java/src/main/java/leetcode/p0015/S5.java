package leetcode.p0015;

import java.util.*;

public class S5 implements Solution {

    // find all unique (a, b, c) tuples, each of which satisfies a + b + c = 0
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ts = new ArrayList<>();
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);
        for (int x : nums) list.add(x);
        Collections.sort(list);
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
                if (a + b > 0) break;
                if (b == bb) continue;
                bb = b;
                c = - (a + b);
                if(list.lastIndexOf(c) > j) {
                    ts.add(Arrays.asList(a, b, c));
                }
            }
        }
        return ts;
    }
}
