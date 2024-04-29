package leetcode.libs;

import java.util.*;
import java.util.stream.*;

public class RMap {

    public RMap() {}

    public static int[] arrayMinMax(int nums[]) {
        if (nums == null) return null;
        int len = nums.length;
        if (len == 0) return null;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        return new int[]{min, max};
    }

    public static int[][] array2InvMap(int nums[]) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        long map_size = max - min + 1;
        if (map_size > Integer.MAX_VALUE) {
            return null; // unsupported
        }
        int [][]invMap = new int[(int)map_size][len + 1];
        for (int i = 0; i < len; i++) {
            int vi = nums[i] - min;
            invMap[vi][++invMap[vi][0]] = i + 1;
        }
        return invMap;
    }

    public static int[][] arrayJump(int nums[]) {
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        int len_1 = len - 1;
        int[][] jump = new int[len][2];
        jump[len_1][0] = 1;
        jump[len_1][1] = 1;
        for (int i = 0, j = 1; i < len_1; j = 1) {
            int __i = i;
            while (__i < len_1 && nums[__i++] == nums[__i]) j++;
            int s = 1;
            while (j > 0) {
                jump[i][0] = j--;
                jump[i][1] = s++;
                i++;
            }
        }
        /*
        System.out.println(Arrays.toString(
            Arrays.stream(jump).map(e -> e[0]).toArray(Integer[]::new)));
        System.out.println(Arrays.toString(
            Arrays.stream(jump).map(e -> e[1]).toArray(Integer[]::new)));
        */
        return jump;
    }

}
