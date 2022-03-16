package leetcode.p0250;

import java.util.*;

class S1 implements Solution {
    /*
     * #255 Verify Preorder Sequence in Binary Search Tree
     *
     * This solution has stack overflow error when size is larger than 8K
     */
    int i;
    public boolean verifyPreorder(int[] preorder)
    {
        if (preorder.length == 0) return true;
        i = 0;
        dfs(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
        return i >= preorder.length;
    }

    private void dfs(int[] pre, long min, long max)
    {
        if (i >= pre.length) return;
        if (pre[i] < min) return;
        if (pre[i] > max) return;
        int save = pre[i];
        i++;
        dfs(pre, min, save);
        dfs(pre, save, max);
    }
}
