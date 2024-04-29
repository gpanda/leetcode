package leetcode.p0115;

import java.util.*;

class S2 implements Solution {

    private char[] s = null;
    private char[] t = null;
    private int[][] dp = null;

    public int numDistinct(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        dp = new int[s.length()][t.length()];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (j == t.length) return 1;
        if (i == s.length) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s[i] == t[j]) {
            dp[i][j] = dfs(i+1, j+1) + dfs(i+1, j);
        } else {
            dp[i][j] = dfs(i+1, j);
        }
        return dp[i][j];
    }

}
