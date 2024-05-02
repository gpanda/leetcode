package leetcode.p0120;

import java.util.*;

class S2 implements Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int [] a : dp) Arrays.fill(a, Integer.MAX_VALUE);
        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> t, int r, int c, int[][] dp) {
        if (r == t.size() - 1)  return t.get(r).get(c);
        if (dp[r][c] == Integer.MAX_VALUE)
            dp[r][c] = Math.min(dfs(t, r+1, c, dp), dfs(t, r+1, c+1, dp))
            + t.get(r).get(c);
        return dp[r][c];
    }
}
