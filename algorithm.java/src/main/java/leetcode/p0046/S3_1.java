package leetcode.p0046;

import java.util.*;
import java.util.stream.*;

public class S3_1 implements Solution {
    // Another Sample Answer, very nice and faster than mine, use SWAP!!!
    // read this code repeatedly :)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        sub_permute(ret, nums, 0);
        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void sub_permute(List<List<Integer>> ret, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i : nums) list.add(i);
            ret.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start) {
                    swap(nums, start, i);
                }
                sub_permute(ret, nums, start + 1);
                if (i > start) {
                    swap(nums, start, i);
                }
            }
        }
    }
}
