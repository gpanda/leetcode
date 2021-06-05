package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S1 implements Solution {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return new ArrayList<List<Integer>>();
        int[] sorted = Arrays.copyOf(nums, len);
        Arrays.sort(sorted);
        int min = sorted[0];
        // int[][] invMap = new int[len][len + 2];
        // for (int i = 0; i < len; i++) {
            // int vi = nums[i] - min;
            // invMap[vi][++invMap[vi][0]] = i + 1;
        // }
        Map<Integer, List<Integer>> invMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            List<Integer> list = invMap.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(Integer.valueOf(0));
            }
            list.add(i);
            invMap.put(nums[i], list);
        }
        Map<Integer, Integer> sioimap = new HashMap<>(len);
        for (int si = 0; si < len; si++) {
            List<Integer> iList = invMap.get(sorted[si]);
            iList.set(0, iList.get(0) + 1);
            int oi = iList.get(iList.get(0));
            sioimap.put(si, oi);
        }

        class MyBitSetComparator implements Comparator<BitSet> {
            public int compare(BitSet a, BitSet b) {
                int alen = a.length();
                int blen = b.length();
                if (alen != blen) {
                    return blen > alen ? 1 : -1;
                }
                BitSet xor = (BitSet) a.clone();
                xor.xor(b);
                int msb = xor.length() - 1;
                if (msb == -1) return 0;
                return a.get(msb) ? 1 : -1;
            }
        }

        int ILEN = len - 3;
        int JLEN = len - 2;
        int HLEN = len - 1;

        int[] offset = new int[ILEN];
        for (int i = 0; i < ILEN; i++) {
            offset[i] = sorted[i] - target;
        }

        List<Object[]> raw = new ArrayList<>();

        for (int i = 0; i < ILEN; i++) {
            int fa = offset[i];
            for (int j = i + 1; j < JLEN; j++) {
                int b = sorted[j];
                int high = HLEN;
                int low = j + 1;
                int fab = fa + b;
                while (low < high) {
                    int sum = fab + sorted[low] + sorted[high];
                    if (sum == 0) {
                        BitSet bs = new BitSet(len);
                        bs.set(len - 1 - sioimap.get(i));
                        bs.set(len - 1 - sioimap.get(j));
                        bs.set(len - 1 - sioimap.get(low));
                        bs.set(len - 1 - sioimap.get(high));
                        Object[] t = new Object[] {
                            bs, Arrays.asList(sorted[i], sorted[j],
                            sorted[low], sorted[high])
                        };
                        raw.add(t);
                        while (low < high && sorted[low++] == sorted[low]) ;
                        while (low < high && sorted[high--] == sorted[high]) ;
                    } else if (sum < 0) {
                        while (low < high && sorted[low++] == sorted[low]) ;
                    } else {
                        while (low < high && sorted[high--] == sorted[high]) ;
                    }
                }
            }
        }

        raw.sort(new Comparator<Object[]>() {
            public int compare(Object[] a, Object[] b) {
                BitSet s1 = (BitSet) a[0];
                BitSet s2 = (BitSet) b[0];
                if (s1.length() != s2.length()) {
                    return s1.length() > s2.length() ? 1 : -1;
                }
                BitSet xor = (BitSet) s1.clone();
                xor.xor(s2);
                if (xor.length() == 0) return 0;
                return s1.get(xor.length()) ? 1 : -1;
            }
        });
        Collections.reverse(raw);
        for (Object[] kv : raw) {
            @SuppressWarnings("unchecked")
            List<Integer> l = (List<Integer>)kv[1];
            results.add(l);
            System.out.println(l);
        }

        return results;
    }
}
