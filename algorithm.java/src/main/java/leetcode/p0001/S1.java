package leetcode.p0001;


import java.util.HashMap;

public class S1 implements Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int[] ret = {-1, -1};
        Integer j = -1;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((j = map.get(target - nums[i])) != null && j.intValue() != i) {
                ret[0] = i;
                ret[1] = j;
                break;
            }
        }
        return ret;
    }

}
