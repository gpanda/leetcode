package leetcode.p0120;

import java.util.*;

class Best implements Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
     if(triangle.isEmpty()) return 0;
        if(triangle.size()==1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        return minimumTotal(triangle, dp, 1);
    }
    public int minimumTotal(List<List<Integer>> triangle, int[] dp, int level) {
        List<Integer> row = triangle.get(level);
        int prev = dp[0], temp;
        dp[0] += row.get(0);
        for(int i=1; i<row.size()-1; i++) {
            temp = dp[i];
            dp[i] = row.get(i) + Math.min(prev, dp[i]);
            prev = temp;
        }
        dp[level] = row.get(level) + prev;
        if(level == triangle.size()-1) {
            int min = dp[0];
            for(int i=1; i<dp.length; i++){
                min = Math.min(dp[i], min);
            }
            return min;
        }
        return minimumTotal(triangle, dp, ++level);
    }
}
