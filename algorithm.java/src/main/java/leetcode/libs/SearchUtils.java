package leetcode.libs;

import java.util.*;

public class SearchUtils
{

    // return the index of the 1st element >= x in a sorted ascending list.
    // return -1 if no element is greater than or equal to x.
    public static int indexOfGoE(List<Integer> a, int x) {
        if (a.size() == 0) return -1;
        if (a.get(a.size() - 1) < x) return -1;
        int l = 0, h = a.size() - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (a.get(m) < x) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return h;
    }

    // return the index of the last element < x in a sorted ascending list.
    // return -1 if no element is less than x.
    public static int indexOfLt(List<Integer> a, int x) { // no duplicate elements
        if (a == null || a.size() == 0) return -1;
        if (a.get(0) >= x) return -1;
        int l = 0, h = a.size() - 1;
        while (l < h) {
            int m = (l + h) / 2 + 1;
            if (a.get(m) >= x) {
                h = m-1;
            } else {
                l = m;
            }
        }
        return l;
    }

}

