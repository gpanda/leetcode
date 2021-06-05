package leetcode.p0001;


import java.util.*;

public class S4 implements Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        Integer v = null;
        for (int i = 0; i < len; i++) {
            if ((v = map.get(target - nums[i])) != null && v != i) {
                return new int[]{v, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

}
