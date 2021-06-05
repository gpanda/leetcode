package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S3 implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        Map<Integer, Integer> set_mapc = new HashMap<>();
        int[] set = new int[len];
        int slen = 0;
        for (int i = 0, j = 0; i < len; i++) {
            Integer c = set_mapc.get(nums[i]);
            if (c == null) {
                c = 1;
                set_mapc.put(nums[i], c);
                set[slen++] = nums[i];
            } else {
                set_mapc.put(nums[i], ++c);
            }
        }
        // System.out.println(set_mapc);

        Map<Integer, Map<Integer, Integer>> sum_map = new HashMap<>();
        int[] sum_set = new int[slen * slen];
        int sum_len = 0;
        for (int i = 0; i < slen; i++) {
            int sum = 0;
            Map<Integer, Integer> m = null;
            int a = set[i];
            if (set_mapc.get(a) > 1) {
                sum = a * 2;
                m = sum_map.get(sum);
                if (m == null) {
                    m = new HashMap<>();
                    sum_map.put(sum, m);
                    sum_set[sum_len++] = sum;
                }
                m.put(a, a);
            }
            for (int j = i + 1; j < slen; j++) {
                int b = set[j];
                sum = a + b;
                m = sum_map.get(sum);
                if (m == null) {
                    m = new HashMap<>();
                    sum_map.put(sum, m);
                    sum_set[sum_len++] = sum;
                }
                m.put(a, b);
            }
        }

        // System.out.println(sum_map);

        for (int i = 0; i < sum_len; i++) {
            int l = sum_set[i];
            int h = target - l;
            Map<Integer, Integer> hm = sum_map.get(h);
            if (hm == null) continue;
            Map<Integer, Integer> lm = sum_map.get(l);
            for (Map.Entry<Integer, Integer> le : lm.entrySet()) {
                int a = le.getKey();
                int b = le.getValue();
                boolean a_e_b = a == b;
                int b_dups = set_mapc.get(b);
                boolean dup_l_3 = b_dups < 3;
                boolean dup_l_2 = b_dups < 2;
                boolean dup_l_4 = b_dups < 4;
                for (Map.Entry<Integer, Integer> he : hm.entrySet()) {
                    int c = he.getKey();
                    int d = he.getValue();
                    if (b > c) continue;
                    if (b == c) {
                        if (dup_l_2) continue;
                        if ((a_e_b || c == d) && dup_l_3) continue;
                        if ((a_e_b && c == d) && dup_l_4) continue;
                    }
                    results.add(Arrays.asList(a, b, c, d));
                }
            }
        }

        // System.out.println("results:" + results);

        return results;
    }
}
