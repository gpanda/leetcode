package leetcode.p0042;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {
    @Override
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0; // < 3
        int maxHeight[] = Arrays.copyOf(height, height.length);
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            } else if (max > height[i]) {
                maxHeight[i] = max;
            }
        }
        int vol = 0;
        max = 0;
        for (int i = height.length - 1; i > 0; i--) {
            if (max < height[i]) {
                max = height[i];
            } else if (max > height[i]) {
                vol += (max > maxHeight[i]) ? maxHeight[i] - height[i] 
                                            : max - height[i];
            }
        }
        return vol;
    }

}
