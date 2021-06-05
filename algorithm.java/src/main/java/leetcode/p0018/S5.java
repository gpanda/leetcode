package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S5 implements Solution {

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

        int faa = offset[0] - 1;
        for (int i = 0; i < ILEN; i++) {
            int fa = offset[i];
            int a  = nums[i];
            if (fa > -3 * a) break;
            if (fa == faa) continue;
            faa = fa;
            int bb = a - 1;
            for (int j = i + 1; j < JLEN; j++) {
                int b = nums[j];
                if (b == bb) continue;
                bb = b;
                int low = j + 1;
                int high = HEND;
                int fab = fa + b;
                if (fab > -a + -b ) break;
                while (low < high) {
                    int sum = fab + nums[low] + nums[high];
                    if (sum == 0) {
                        results.add(
                            Arrays.asList(a, b, nums[low], nums[high]));
                        while (low < high && nums[low++] == nums[low]) ;
                        while (low < high && nums[high--] == nums[high]) ;
                    } else if (sum < 0) {
                        while (low < high && nums[low++] == nums[low]) ;
                    } else {
                        while (low < high && nums[high--] == nums[high]) ;
                    }
                }
            }
        }

        return results;
    }
}
