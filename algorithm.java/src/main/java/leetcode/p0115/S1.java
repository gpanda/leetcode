package leetcode.p0115;

import java.util.*;

class S1 implements Solution {

    public int numDistinct(String s, String t) {

        Map<Character, Integer> curIdx = new HashMap<>();     // curIdx table
        Map<Character, List<Integer>> imap = new HashMap<>(); // idx table
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curIdx.get(c) == null) {
                curIdx.put(c, 0);
            }
            List<Integer> idx = imap.get(s.charAt(i));
            if (idx == null) {
                idx = new ArrayList<>();
                imap.put(c, idx);
            }
            idx.add(i);
        }
        int d = 0;
        Character cU = t.charAt(d);
        List<Integer> upIdx = imap.get(cU);
        if (upIdx == null) return 0;
        List<Integer> upCount = new ArrayList<>();
        for (int i = 0; i < upIdx.size(); i++) upCount.add(1);
        d++;
        while (d < t.length()) {
            int i = curIdx.get(cU);
            if (i >= upIdx.size()) return 0;
            Character cL = t.charAt(d);
            List<Integer> lowIdx = imap.get(cL);
            if (lowIdx == null) return 0;
            int j = curIdx.get(cL);
            while (j < lowIdx.size() && upIdx.get(i) >= lowIdx.get(j)) {
                j++;
            }
            if (j == lowIdx.size()) return 0;
            else curIdx.put(cL, j);
            List<Integer> lowCount = new ArrayList<>();
            int count = 0;
            boolean virgin = true;
            int k = 0;
            while (i < upIdx.size() && j < lowIdx.size()) {
                if (upIdx.get(i) < lowIdx.get(j)) {
                    count += upCount.get(k++);
                    i++;
                } else {
                    if (virgin == true) {
                        virgin = false;
                        curIdx.put(cU, i);
                    }
                    lowCount.add(count);
                    j++;
                }
            }
            while (j < lowIdx.size()) {
                lowCount.add(count);
                j++;
            }
            cU = cL;
            upIdx = lowIdx;
            upCount = lowCount;
            d++;
        }
        int num = 0;
        for (Integer i : upCount) num += i;
        return num;
    }


}
