package leetcode.p0015;

import java.util.*;

public class S2 implements Solution {

    private class List3Comparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> o1, List<Integer> o2) { // object comparison: use "equals" not "=="
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Map<Integer, Set<Integer>> setMap = new HashMap<>(len);
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = null;
        Set<Integer> set = null;
        for (int i = 0; i < len - 2; i++) {
            int a = nums[i];
            if (setA.contains(a)) {
                continue;
            } else {
                setA.add(a);
            }
            setB = setMap.get(a);
            if (setB == null) {
                setB = new HashSet<>();
                setMap.put(a, setB);
            }
            for (int j = i + 1; j < len - 1; j++) {
                int b = nums[j];
                if (setB.contains(b)) continue;
                int c = -(a + b);
                Integer ic = map.get(c);
                if (ic == null || ic <= j) continue;
                setB.add(b);
                setB.add(c);
                set = setMap.get(b);
                if(set == null) {
                    set = new HashSet<>();
                    setMap.put(b, set);
                }
                set.add(a);
                set.add(c);
                set = setMap.get(c);
                if(set == null) {
                    set = new HashSet<>();
                    setMap.put(c, set);
                }
                set.add(a);
                set.add(b);

                List<Integer> list = Arrays.asList(a, b, c);
                Collections.sort(list);
                ts.add(list);
            }
        }
        return new ArrayList<>(ts);
    }
}
