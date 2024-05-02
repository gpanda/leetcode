package leetcode.p0120;

import java.util.*;

class S3 implements Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] min = triangle.get(triangle.size()-1).stream()
            .mapToInt(Integer::intValue).toArray();
        for (int r = triangle.size() - 2; r > -1; r--) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                min[c] = row.get(c) + Math.min(min[c], min[c+1]);
            }
        }
        return min[0];
    }
}
