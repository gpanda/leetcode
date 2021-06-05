package leetcode.p0004;

import java.util.*;

public class S1 implements Solution {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            System.out.println("Exception");
            return -1.0;
        }
        if (nums1.length == 0) {
            return findMedianSortedArray(nums2, 0, nums2.length - 1);
        }
        if (nums2.length == 0) {
            return findMedianSortedArray(nums1, 0, nums1.length - 1);
        }
        if (nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        } // it would be always nums1.length <= nums2.length
        int l1 = 0, h1 = nums1.length - 1;
        int l2 = 0, h2 = nums2.length - 1;
        while (h1 > l1 && h2 > l2) {
            double med1 = findMedianSortedArray(nums1, l1, h1);
            double med2 = findMedianSortedArray(nums2, l2, h2);
            if (med1 == med2) {
                return med1;
            } else {
                int step = (h1 - l1 + 1) / 2;
                if (med1 < med2) {
                    l1 += step;
                    h2 -= step;
                } else {
                    h1 -= step;
                    l2 += step;
                }
            }
        }
        if (h1 == l1 && h2 == l2) {
            return (nums1[l1] + nums2[l2]) / 2.0;
        }
        if (h1 == l1) {
            return findMedianSortedArrayPlus1(nums2, nums1[l1], l2, h2);
        } else {
            return findMedianSortedArrayPlus1(nums1, nums2[l2], l1, h1);
        }
    }

    private double findMedianSortedArray(int[] a, int l, int h) {
        int len = h - l + 1;
        return (a[l + len / 2] + a[l + (len - 1) / 2]) / 2.0;
    }

    private double findMedianSortedArrayPlus1(int[] a, int x, int l, int h) {
        int len = h - l + 2;
        int mp1 = l + (len - 1) / 2;
        int mp2 = l + len / 2;
        int xp = insert(a, x, l, h);
        if (xp < mp1) {
            mp1--;
            mp2--;
        } else if (xp == mp1) {
            if (len % 2 == 0) {
                return (x + a[mp2 - 1]) / 2.0;
            } else {
                return x;
            }
        } else if (xp == mp2) {
            if (len % 2 == 0) {
                return (a[mp1] + x) / 2.0;
            } else {
                return x;
            }
        } // else if (xp > mp2)
        return (a[mp1] + a[mp2]) / 2.0;
    }

    private int insert(int[] a, int x, int l, int h) {
        while (l < h) {
            int m = (l + h) / 2;
            if (x == a[m]) {
                return m;
            } else if (x < a[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l > h) {
            return l;
        } else { // l == h
            if (x <= a[l]) {
                return l;
            } else {
                return l + 1;
            }
        }
    }

}
