package leetcode.p0001;


import java.util.HashMap;

public class S2 implements Solution {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Integer j;
        for (int i = 0; i < len; i++) {
            if ((j = map.get(target - nums[i])) != null && j.intValue() != i) {
                return new int[]{i, j};
            }
        }
        return new int[2];
    }
}
