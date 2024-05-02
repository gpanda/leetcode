package leetcode.p0120;

import java.util.*;

class S1 implements Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(triangle, 0, 0, map);
    }

    private int dfs(List<List<Integer>> t, int r, int c,
        Map<Integer, Integer> m) {
        if (r == t.size())  return 0;
        Integer min = m.get(r*1000 + c);
        if (min != null) {
            return min;
        }
        int v = t.get(r).get(c);
        min = v + Math.min(dfs(t, r+1, c, m), dfs(t, r+1, c+1, m));
        m.put(r*1000+c, min);
        return min;
    }
}
