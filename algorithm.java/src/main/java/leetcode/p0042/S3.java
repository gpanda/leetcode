package leetcode.p0042;

import java.util.*;
import java.util.stream.*;

public class S3 implements Solution {
    @Override
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0; // < 3
        int maxFromLeft[] = new int[height.length];
        maxFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxFromLeft[i] = java.lang.Math.max(maxFromLeft[i-1], height[i]);
        }
        int vol = 0;
        int maxFromRight = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            if (maxFromRight > height[i]) {
                vol += java.lang.Math.min(maxFromRight, maxFromLeft[i]) - height[i];
            } else {
                maxFromRight = height[i];
            }
        }
        return vol;
    }

}
