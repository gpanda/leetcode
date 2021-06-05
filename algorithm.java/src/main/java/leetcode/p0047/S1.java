package leetcode.p0047;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] a = map.get(nums[i]);
            if (a == null) {
                map.put(nums[i], new int[]{1, 0});
            } else {
                a[0]++;
            }
        }
        int[] index = new int[map.size()];
        int i = 0;
        for (Integer a : map.keySet()) {
            index[i++] = a;
        }
        Arrays.sort(index);
        helper(ret, list, index, map, nums.length);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> lst, int[] idx,
        Map<Integer, int[]> map, int len) {
        if (lst.size() == len) {
            ret.add(new ArrayList<Integer>(lst));
        } else {
            for (int i = 0; i < idx.length; i++) {
                int[] e = map.get(idx[i]);
                if (e[1] == e[0]) {
                    continue;
                } else {
                    lst.add(idx[i]);
                    e[1]++;
                    helper(ret, lst, idx, map, len);
                    Integer a = lst.remove(lst.size() - 1);
                    map.get(a)[1]--;
                }
            }
        }
    }
}

