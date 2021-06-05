package leetcode.p0046;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    // AC, check S2 Sample Answer, which is much better
    private List<List<Integer>> sub_permute(int[] nums, int offset) {
        if (offset == nums.length - 1) {
            List<List<Integer>> sub = new ArrayList<>();
            List<Integer> p = new ArrayList<Integer>();
            p.add(nums[offset]);
            sub.add(p);
            return sub;
        }
        List<List<Integer>> sub = sub_permute(nums, offset+1);
        List<List<Integer>> newsub = new ArrayList<List<Integer>>();
        for (List<Integer> lst : sub) {
            for (int i = 0; i <= lst.size(); i++) {
                List<Integer> newlst = new ArrayList<Integer>(lst);
                newlst.add(i, nums[offset]);
                newsub.add(newlst);
            }
        }
        return newsub;
    }

    @Override
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Arrays.asList(Arrays.asList());
        return sub_permute(nums, 0);
    }
}
