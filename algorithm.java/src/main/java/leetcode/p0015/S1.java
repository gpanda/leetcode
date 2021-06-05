package leetcode.p0015;

import java.util.*;

public class S1 implements Solution {

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
        Set<Integer> set1 = new HashSet<>(len);
        Set<Integer> set2 = new HashSet<>(len);
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        int a,b,c;
        for (int i = 0; i < len - 2; i++) {
            a = nums[i];
            if (set1.contains(a)) continue;
            set1.add(a);
            set2.clear();
            for (int j = i + 1; j < len - 1; j++) {
                b = nums[j];
                if (set2.contains(b)) continue;
                c = -a - b;
                Integer ic = map.get(c);
                if (ic == null || ic <= j) continue;
                List<Integer> list = Arrays.asList(a, b, c);
                Collections.sort(list);
                ts.add(list);
                set2.add(b);
                set2.add(c);
            }
        }
        return new ArrayList<>(ts);
    }
}
