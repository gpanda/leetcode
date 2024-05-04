package leetcode.p0121;

import java.util.*;

class S1 implements Solution {
    /*
     */
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++)
            if (prices[i] < buy) buy = prices[i]; else maxp = Math.max(maxp, prices[i] - buy);
        return maxp;
    }
}
