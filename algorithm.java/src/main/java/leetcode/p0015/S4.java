package leetcode.p0015;

import java.util.*;

public class S4 implements Solution {

    private class List3Comparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> o1, List<Integer> o2) {
            // object comparison: use "equals" not "=="
            if (o1.get(0).equals(o2.get(0))) {
                if (o1.get(1).equals(o2.get(1))) {
                    return o1.get(2) - o2.get(2);
                } else {
                    return o1.get(1) - o2.get(1);
                }
            } else {
                return o1.get(0) - o2.get(0);
            }
        }
    }

    // find all unique (a, b, c) tuples, each of which satisfies a + b + c = 0
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ts = new TreeSet<>(new List3Comparator());
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long map_size = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        map_size = (long) max - (long) min + 1L;
        if (map_size > Integer.MAX_VALUE) return null;
        int[] map = new int[(int)map_size];
        int[] set1 = new int[(int)map_size];
        int[] set2 = new int[(int)map_size];
        for (int i = 0; i < len; i++) {
            map[nums[i] - min] = i + 1;
        }
        int a,b,c;
        for (int i = 0; i < len - 2; i++) {
            a = nums[i];
            if (set1[a - min] == 1) continue;
            set1[a - min] = 1;
            for (int j = i + 1; j < len - 1; j++) {
                b = nums[j];
                if (set2[b - min] == i + 1) continue;
                c = -a - b;
                if (c < min || c > max) continue;
                int ic = map[c - min];
                if (ic == 0 || ic - 1 <= j) continue;
                List<Integer> list = Arrays.asList(a, b, c);
                Collections.sort(list);
                ts.add(list);
                set2[b - min] = i + 1;
                set2[c - min] = i + 1;
            }
        }
        return new ArrayList<>(ts);
    }
}
