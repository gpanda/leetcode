package leetcode.p0047;

import java.util.*;
import java.util.stream.*;

public class S2 implements Solution {
    // Sample Answer: 1ms vs S1(mine) 2ms, no HashMap, need read repeatedly
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort is necessary
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        backtrack(resultList, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return resultList;
    }

    public void backtrack(List<List<Integer>> resultList, List<Integer> current, int[] nums, boolean[] used) {
        if( current.size() == nums.length )
            resultList.add(new ArrayList<Integer>(current));
        else{
            for(int i = 0; i < nums.length; i++) {
                if( used[i] || ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) ) // remove duplicate
                    continue;
                current.add(nums[i]);
                used[i] = true;
                backtrack(resultList, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}

