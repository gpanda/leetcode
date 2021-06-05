package leetcode.p0085;

import java.util.*;

public class S2 implements Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        List<List<int[]>> list = new ArrayList<>(matrix.length);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            List<int[]> l = new ArrayList<>();
            int j = 0;
            while (j < matrix[i].length) {
                while (j < matrix[i].length && matrix[i][j] == '0') j++;
                if (j == matrix[i].length) break;
                int[] a = new int[2];
                a[0] = j;
                while (j < matrix[i].length && matrix[i][j] == '1') j++;
                a[1] = j;
                int m = a[1] - a[0];
                if (m > max) max = m;
                l.add(a);
            }
            list.add(l);
        }
        List<int[]> l3 = new ArrayList<>();
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                List<int[]> l1 = list.get(j);
                List<int[]> l2 = list.get(j+1);
                ListIterator<int[]> i1 = l1.listIterator();
                ListIterator<int[]> i2 = l2.listIterator();
                int[] r1 = null;
                int[] r2 = null;
                int h = matrix.length - i + 1;
                while (i1.hasNext() && i2.hasNext()) {
                    r1 = i1.next();
                    r2 = i2.next();
                    int x0 = Math.max(r1[0], r2[0]);
                    int x1 = Math.min(r1[1], r2[1]);
                    if (x1 > x0) {
                        // System.out.println("h:" + h + " (x1-x0):" + (x1-x0));
                        max = Math.max(max, (x1 - x0) * h);
                        int[] r3 = new int[]{x0, x1};
                        l3.add(r3);
                    }
                    if (r1[1] > r2[1]) {
                        i1.previous();
                    } else if (r1[1] < r2[1]) {
                        i2.previous();
                    }
                }
                l1.clear();
                l1.addAll(l3);
                l3.clear();
            }
            list.remove(i);
        }
        return max;
    }
}
