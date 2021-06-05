package leetcode.p0042;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    private int trapBetween(int l, int r, int[] height) {
        int lowerTop = height[l] <= height[r] ? height[l] : height[r];
        int vol = 0;
        for (int i = l + 1; i < r; i++) {
            if (lowerTop <= height[i]) continue;
            vol += lowerTop - height[i];
        }
        return vol;
    }


    @Override
    public int trap(int[] height) {
        if (height == null || height.length == 0 || height.length == 1)
            return 0;
        List<int[]> tops = new ArrayList<int[]>();
        for (int i = 0; i < height.length - 1;) {
            // ascending
            while (i < height.length - 1 && height[i] <= height[i+1]) i++;
            tops.add(new int[]{height[i], i});
            if (i >= height.length - 1) break;
            // descending
            while (i < height.length - 1 && height[i] >= height[i+1]) i++;
        }
        if (tops.size() <= 1) return 0;
        // tops.stream().map(i->Arrays.toString(i)).forEach(System.out::println);
        tops.sort(Comparator.comparing((int[] arr) -> arr[0]).reversed());
        // tops.stream().map(i->Arrays.toString(i)).forEach(System.out::println);
        int l = 0, r = 0;
        if (tops.get(0)[1] < tops.get(1)[1]) {
            l = tops.get(0)[1];
            r = tops.get(1)[1];
        } else {
            l = tops.get(1)[1];
            r = tops.get(0)[1];
        }
        int vol = trapBetween(l, r, height);
        for (int i = 2; i < tops.size(); i++) {
            int k = tops.get(i)[1];
            if (k < l) {
                vol += trapBetween(k, l, height);
                l = k;
            } else if (k > r) {
                vol += trapBetween(r, k, height);
                r = k;
            }
        }
        return vol;
    }

}
