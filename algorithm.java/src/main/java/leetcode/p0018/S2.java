package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S2 implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return results;
        Arrays.sort(nums);

        int ILEN = len - 3;
        int JLEN = len - 2;
        int HEND = len - 1;

        int[] offset = new int[JLEN];
        for (int i = 0; i < JLEN; i++) {
            offset[i] = nums[i] - target;
        }

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
                    int sum = fab + nums[low] + nums[high];
                    if (sum == 0) {
                        results.add(Arrays.asList(
                            nums[i], nums[j], nums[low], nums[high])
                        );
                        while (low < high && nums[low++] == nums[low]) ;
                        while (low < high && nums[high--] == nums[high]) ;
                    } else if (sum < 0) {
                        while (low < high && nums[low++] == nums[low]) ;
                    } else {
                        while (low < high && nums[high--] == nums[high]) ;
                    }
                }
                while (j < JLEN && nums[j++] == nums[j]) ;
            }
            while (i < ILEN && offset[i++] == offset[i]) ;
        }

        return results;
    }
}
