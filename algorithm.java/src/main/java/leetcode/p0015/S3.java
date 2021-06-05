package leetcode.p0015;

import java.util.*;

public class S3 implements Solution {

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
        // long t0 = System.currentTimeMillis();
        Set<List<Integer>> ts = new TreeSet<>(new List3Comparator());
        int len = nums.length;
        Set<Integer> set1 = new HashSet<>((int) (len * .75));
        Set<Integer> set2 = new HashSet<>((int) (len * .75));
        Map<Integer, Integer> map = new HashMap<>(len);
        // long t1 = System.currentTimeMillis();
        // System.out.println("Declare:" + (t1 - t0) + "ms.");
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        // long t2 = System.currentTimeMillis();
        // System.out.println("Init HashMap:" + (t2 - t1) + "ms.");
        int a,b,c;
        // long ta1 = 0;
        // long ta2 = 0;
        // long tsum = 0;
        for (int i = 0; i < len - 2; i++) {
            a = nums[i];
            if (set1.contains(a)) continue;
            set1.add(a);
            set2.clear();
            for (int j = i + 1; j < len - 1; j++) {
                b = nums[j];
                if (set2.contains(b)) continue;
                c = -a - b;
                // ta1 = System.currentTimeMillis();
                Integer ic = map.get(c);
                // ta2 = System.currentTimeMillis();
                // tsum += ta2 - ta1;
                if (ic == null || ic <= j) continue;
                List<Integer> list = Arrays.asList(a, b, c);
                Collections.sort(list);
                ts.add(list);
                set2.add(b);
                set2.add(c);
            }
        }
        // System.out.println("HashMap:" + tsum + "ms.");
        // long t3 = System.currentTimeMillis();
        // System.out.println("Compute:" + (t3 - t2) + "ms.");
        List<List<Integer>> result = new ArrayList<>(ts);
        // long t4 = System.currentTimeMillis();
        // System.out.println("Convert:" + (t4 - t3) + "ms.");
        // return new ArrayList<>(ts);
        // return new ArrayList<>(Arrays.asList(Arrays.asList(0, 0, 0)));
        return result;
    }
}
