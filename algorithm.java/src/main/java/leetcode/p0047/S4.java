package leetcode.p0047;

import java.util.*;
import java.util.stream.*;

public class S4 implements Solution {
    // Another Sample Answer: 1ms vs S1(mine) 2ms, use SWAP !!!
    // Need to read repeatedly.
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort is necessary
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        sub_permute(resultList, nums, 0);
        return resultList;
    }

    public void sub_permute(List<List<Integer>> result, int[] nums, int start) {
        if (start >= nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i : nums) list.add(i);
            result.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (!isSwap(nums, start, i)) {
                    continue;
                } else {
                    swap(nums, start, i);
                    sub_permute(result, nums, start+1);
                    swap(nums, start, i);
                }
            }
        }
    }

    private boolean isSwap(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

