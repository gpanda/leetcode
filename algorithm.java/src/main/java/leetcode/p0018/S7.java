package leetcode.p0018;

import java.math.*;
import java.util.*;

public class S7 implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        int len = nums.length;
        if (len < 4) return results;
        Arrays.sort(nums);

        int HEND = len - 1;
        int max = nums[HEND];
        if (4 * max < target) return results; // max is too small

        int IEND = HEND - 2;
        int JEND = HEND - 1;

        int aa = nums[0] - 1;
        for (int i = 0; i < IEND; i++) {
            int a  = nums[i];
            if (a == aa) continue; // avoid duplicate
            aa = a;
            if (4 * a > target) break; // a is too large
            if (4 * a == target) {
                if (i + 3 < len && a == nums[i + 3]) {
                    results.add(Arrays.asList(a, a, a, a));
                    break;
                }
            }
            if (a + 3 * max < target) continue; // a is too small
            int t3 = target - a;
            int bb = a - 1;
            for (int j = i + 1; j < JEND; j++) {
                int b = nums[j];
                if (b == bb) continue; // avoid duplicate
                bb = b;
                if (3 * b > t3) break; // b is too large
                if (3 * b == t3) {
                    if (j + 2 < len && b == nums[j + 2]) {
                        results.add(Arrays.asList(a, b, b, b));
                    }
                    break;
                }
                if (2 * (a + b) > target) break; // a + b is too large
                if (b + 2 * max < t3) continue; // b is too small
                int t2 = t3 - b;
                int low = j + 1;
                int high = HEND;
                int sum, x;
                while (low < high) {
                    if (2 * nums[low] > t2) break;
                    if (2 * nums[high] < t2) break;
                    sum = nums[low] + nums[high];
                    if (sum == t2) {
                        results.add(
                            Arrays.asList(a, b, nums[low], nums[high]));
                        x = nums[low];
                        while (++low < high && nums[low] == x) ;
                        x = nums[high];
                        while (low < --high && nums[high] == x) ;
                    } else if (sum < t2) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return results;
    }
}
