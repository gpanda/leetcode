package leetcode.p0084;

import java.util.*;

public class SS2 implements Solution {
   public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>(); 
        int maxArea = 0, n = heights.length; 
        for(int i=0; i<heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int area = heights[st.pop()] * (st.isEmpty() ? i : i-st.peek()-1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int area = heights[st.pop()] * (st.isEmpty() ? n : n-st.peek()-1); 
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
