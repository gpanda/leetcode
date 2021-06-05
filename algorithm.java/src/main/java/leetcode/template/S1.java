package leetcode.template;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {

    @Override
    public List<List<Integer>> func_template(int[] nums, int divisor) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>(len / divisor);
        for (int i = 0; i <= len - divisor; i+=divisor) {
            result.add(Arrays
                .stream(nums, i, i + divisor)
                .boxed()
                .collect(Collectors.toList())
            );
        }
        return result;
    }

    @Override
    public void func_template2() {}
}
