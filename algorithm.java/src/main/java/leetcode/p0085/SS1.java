package leetcode.p0085;

import java.util.*;

public class SS1 implements Solution {
    public int maximalRectangle(char[][] matrix) {
        final int rows = matrix.length;
        if (rows == 0)
            return 0;
        
        final int cols = matrix[0].length;
        if (cols == 0)
            return 0;
        
        int output = 0;
        int[] results = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    results[j] = 0;
                } else {
                    results[j]++;
                }
            }
            output = Math.max(output, findMaxRec(results));
        }
        
        return output;
    }
    
    private int findMaxRec(int[] results) {
        final int n = results.length;
        int[] leftMaxIndex = new int[n];
        for (int i = 0; i < n; i++) {
            leftMaxIndex[i] = i;
            while (leftMaxIndex[i] - 1 >= 0 && results[leftMaxIndex[i] - 1] >= results[i]) {
                leftMaxIndex[i] = leftMaxIndex[leftMaxIndex[i] - 1];
            }
        }
        int[] rightMaxIndex = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightMaxIndex[i] = i;
            while (rightMaxIndex[i] + 1 <= n - 1 && results[rightMaxIndex[i] + 1] >= results[i]) {
                rightMaxIndex[i] = rightMaxIndex[rightMaxIndex[i] + 1];
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int curArea = results[i] * (rightMaxIndex[i] - leftMaxIndex[i] + 1);
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
    }
}
