package leetcode.p0046;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {
    // Sample Answer, very nice and faster than mine !!!
    // read this code repeatedly :)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, ret, list);
        return ret;
    }

    private void helper(int[] nums,  List<List<Integer>> ret, List<Integer> list) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                } else {
                    list.add(nums[i]);
                    helper(nums, ret, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
