package leetcode.p0038;

import java.util.*;
import java.util.stream.*;

public class S3 implements Solution {
    static String[] table = new String[31];
    static {
        table[1] = "1";
    }

    @Override
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (table[n] == null) {
            String s_n_1 = countAndSay(n-1);
            StringBuilder s_n = new StringBuilder();
            char c = s_n_1.charAt(0);
            int count = 1;
            for (int i = 1; i < s_n_1.length(); i++) {
                if (s_n_1.charAt(i) == c) {
                    count++;
                } else {
                    s_n.append(count).append(c);
                    c = s_n_1.charAt(i);
                    count = 1;
                }
            }
            s_n.append(count).append(c);
            table[n] = s_n.toString();
        }
        return table[n];
    }

}
