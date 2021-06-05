package leetcode.p0038;

import java.util.*;
import java.util.stream.*;

public class S1 implements Solution {
    // Use StringBuilder instead of String when concatenation
    // Performance!!!

    @Override
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String lastsay = "1";
        StringBuilder nextsay = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            char c = lastsay.charAt(0);
            int count = 1;
            for (int j = 1; j < lastsay.length(); j++) {
                if (lastsay.charAt(j) == c) {
                    count++;
                } else {
                    nextsay.append(count).append(c);
                    count = 1;
                    c = lastsay.charAt(j);
                }
            }
            nextsay.append(count).append(c);
            lastsay = nextsay.toString();
            nextsay.setLength(0);
        }
        return lastsay;
    }

}
