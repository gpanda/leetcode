package leetcode.p0120;

import java.util.*;

class S4 implements Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> min = new ArrayList<>();
        for (Integer i : triangle.get(triangle.size() - 1)) min.add(i);
        for (int row = triangle.size() - 2; row >= 0; row--)
            for (int col = 0; col <= row; col++)
                min.set(col, triangle.get(row).get(col) + Math.min(min.get(col), min.get(col+1)));
        return min.get(0);
    }
}
