package leetcode.p0250;

import java.util.*;

class S2 implements Solution {
    /*
     * #255 Verify Preorder Sequence in Binary Search Tree
     */
    public boolean verifyPreorder(int[] preorder)
    {
        if (preorder.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        long min = Long.MIN_VALUE;
        while (i < preorder.length) {
            if (preorder[i] < min) return false;
            if (stack.isEmpty() || preorder[i] < stack.peek()) {
                stack.push(preorder[i++]);
            } else {
                min = stack.pop();
            }
        }
        return i >= preorder.length;
    }
}
