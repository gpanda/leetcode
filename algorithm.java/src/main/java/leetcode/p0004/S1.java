package leetcode.p0004;

import java.util.*;

public class S1 implements Solution {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] na = nums1, nb = nums2;
        int la = 0, ha = na.length - 1;
        int lb = 0, hb = nb.length - 1;
        while (true) {
            int len_a = ha - la + 1;
            int len_b = hb - lb + 1;
            int ma0 = 0, ma1 = 0;
            if (len_a > 0) {
                ma0 = na[la + (len_a - 1) / 2];
                ma1 = na[la + len_a / 2];
                if (len_b <= 0) {
                    return (ma0 + ma1) / 2.0;
                }
            }
            int mb0 = 0, mb1 = 0;
            if (len_b > 0) {
                mb0 = nb[lb + (len_b - 1) / 2];
                mb1 = nb[lb + len_b / 2];
                if (len_a <= 0) {
                    return (mb0 + mb1) / 2.0;
                }
            }
            if (len_a <= 0 && len_b <= 0) {
                System.out.println("Exception!");
                return -1.0;
            } // now, len_a > 0 && len_b > 0
            if (len_a == 1 && len_b == 1) {
                return (ma0 + mb0) / 2.0;
            }
            if (len_b == 1) {
                len_b = len_a;
                len_a = 1;
                int t;
                t = ma0; ma0 = mb0; mb0 = t;
                t = ma1; ma1 = mb1; mb1 = t;
                t = la; la = lb; lb = t;
                int[] r;
                r = na; na = nb; nb = r;
            }
            if (len_a == 1) {
                if (len_b % 2 == 0) {
                    if (ma0 <= mb0) {
                        return mb0;
                    } else if (ma0 >= mb1) {
                        return mb1;
                    } else {
                        return ma0;
                    }
                } else { // len_b is odd and >= 3
                    if (ma0 == mb0) {
                        return ma0;
                    }
                    int mb0_1 = nb[lb + (len_b - 1) /2 - 1];
                    if (ma0 <= mb0_1) {
                        return (mb0 + mb0_1) / 2.0;
                    }
                    int mb1_1 = nb[lb + len_b /2 + 1];
                    if (ma0 >= mb1_1) {
                        return (mb1 + mb1_1) / 2.0;
                    }
                    return (ma0 + mb0) / 2.0;
                }
            }
            // make sure that ma0 <= mb0
            if (ma0 > mb0) { // switch a with b
                int t;
                t = la; la = lb; lb = t;
                t = ha; ha = hb; hb = t;
                t = ma0; ma0 = mb0; mb0 = t;
                t = ma1; ma1 = mb1; mb1 = t;
                t = len_a; len_a = len_b; len_b = t;
                int[] r;
                r = na; na = nb; nb = r;
            }
            if (mb0 <= ma1 && ma1 <= mb1) { // ma0 mb0 ma1 mb1
                return (mb0 + ma1) / 2.0;
            }
            if (mb1 <= ma1) {               // ma0 mb0 mb1 ma1
                return (mb0 + mb1) / 2.0;
            }
            // now, ma0 ma1 mb0 mb1, remove logarithmically
            int step = len_a <= len_b ? len_a / 2 : len_b / 2;
            la += step;
            hb -= step;
        }
    }
}
