package leetcode.p0045;

import java.util.*;
import java.util.stream.*;

public class S4 implements Solution {
    // Sample answer, clean and simple, but performance may not be bettter
    // then S3
    public int jump(int[] nums) {
        int cur = 0, rst = 0, last = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>cur) return -1;
            if(i>last) 
            {
                last = cur;
                rst++;
            }
            cur = Math.max(cur, i+nums[i]);
        }
        return rst;
    }
}
