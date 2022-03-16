package leetcode.p0097;
// 
import java.util.*;

class S1 implements Solution {
    /*
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        boolean dp[][] = new boolean[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (dp[i][j-1] == true &&
                            s2.charAt(j-1) == s3.charAt(i+j-1)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else if (j == 0) {
                    if (dp[i-1][j] == true &&
                            s1.charAt(i-1) == s3.charAt(i+j-1)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (dp[i][j-1] == true &&
                            s2.charAt(j-1) == s3.charAt(i+j-1)) {
                        dp[i][j] = true;
                    } else if (dp[i-1][j] == true &&
                            s1.charAt(i-1) == s3.charAt(i+j-1)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
