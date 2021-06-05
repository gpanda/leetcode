package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S4 implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return results;
        Arrays.sort(nums);

        int ILEN = len - 3;
        int JLEN = len - 2;
        int HEND = len - 1;

        int[] offset = new int[len];
        for (int i = 0; i < len; i++) {
            offset[i] = nums[i] - target;
        }
        int[][] jump = new int[len][2];
        jump[HEND][0] = 1;
        jump[HEND][1] = 1;
        for (int i = 0, j = 1; i < HEND; j = 1) {
            int __i = i;
            while (__i < HEND && nums[__i++] == nums[__i]) j++;
            int s = 1;
            while (j > 0) {
                jump[i][0] = j--;
                jump[i][1] = s++;
                i++;
            }
        }

        int[][] sumap = new int[len][len];
        int i = 0;
        while (i < ILEN) {
            int fa = offset[i];
            int j = i + 1;
            while (j < JLEN) {
                int b = nums[j];
                int high = HEND;
                int low = j + 1;
                int fab = fa + b;
                while (low < high) {
                    if (sumap[low][high] == 0) sumap[low][high] =
                        nums[low] + nums[high];
                    int sum = fab + sumap[low][high];
                    if (sum == 0) {
                        results.add(Arrays.asList(
                            nums[i], nums[j], nums[low], nums[high])
                        );
                        low += jump[low][0];
                        high -= jump[high][1];
                    } else if (sum < 0) {
                        low += jump[low][0];
                    } else {
                        high -= jump[high][1];
                    }
                }
                j += jump[j][0];
            }
            i += jump[i][0];
        }

        return results;
     }
}
