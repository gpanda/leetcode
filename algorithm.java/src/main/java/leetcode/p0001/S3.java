package leetcode.p0001;


import java.util.HashMap;

public class S3 implements Solution {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int len = nums.length;
        Integer j;
        for (int i = 0; i < len; i++) {
            if ((j = map.get(target - nums[i])) != null && j.intValue() != i) {
                return new int[]{j, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
