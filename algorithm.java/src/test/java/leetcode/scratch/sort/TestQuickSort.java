package leetcode.scratch.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import leetcode.TestBase;

public class TestQuickSort extends TestBase {

    // chagne
    private static final String infile = IF_PREFIX + "scratch/sort/qs.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public int[] E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2]; // change

                params[0] = getListOfInt(sc);
                if (params[0] == null) break;

                params[1] = getListOfInt(sc);
                if (params[1] == null) break;

                params_list.add(params);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return params_list;
    }

    private void qsort(int[] a, int l, int h) {
        if (l >= h) return;
        int l2 = l, h2 = h;
        int t = a[l];
        int i = l + 1;
        while (l < h) {
            if (a[i] <= t) {
                a[l++] = a[i++];
            } else {
                swap(a, i, h);
                h--;
            }
        }
        a[l] = t;
        qsort(a, l2, l-1);
        qsort(a, l+1, h2);
    }

    private void qsort2(int[] a, int l, int h) {
        if (l >= h) return;
        int l2 = l, h2 = h;
        int t = a[l];
        while (l < h) {
            if (a[l+1] <= t) {
                a[l] = a[l+1];
                l++;
            } else {
                swap(a, l+1, h);
                h--;
            }
        }
        a[l] = t;
        qsort2(a, l2, l-1);
        qsort2(a, l+1, h2);
    }

    private void qsort4(int[] a, int l, int h) {
        if (l >= h) return;
        int l2 = l;
        int h2 = h;
        int m = l + (h - l) / 2;
        int pivot = a[m];
        while (l < h) {
            if (a[l] <=  pivot) {
                l++;
            } else {
                swap(a, l, h);
                h--;
            }
        }
        if (a[l] < pivot) {
            swap(a, l, m);
            h++;
        } else if (a[l] > pivot) {
        }
        l--;
        qsort(a, l2, l);
        qsort(a, h, h2);
    }

    private void qsort3(int[] a, int l, int h) {
        if (h <= l) return;
        int p = partition(a, l, h);
        qsort3(a, l, p);
        qsort3(a, p+1, h);
    }

    private int partition(int[]a, int l, int h) {
        if (l >= h) return l;
        int pivot = a[l + (h - l) / 2];
        while(true) {
            while (a[l] < pivot) l++; // don't need to check l cross h here
            while (a[h] > pivot) h--; // don't need to check h cross l here
            if (l >= h) return h; // not l but h, to avoid infinite recursion
            swap(a, l, h);
            l++;
            h--;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void test_1() {
        int[] I0_copy = Arrays.copyOf(I0, I0.length);
        qsort(I0_copy, 0, I0_copy.length - 1);
        assertArrayEquals(E, I0_copy);
    }

    @Test
    public void test_2() {
        int[] I0_copy = Arrays.copyOf(I0, I0.length);
        qsort2(I0_copy, 0, I0_copy.length - 1);
        assertArrayEquals(E, I0_copy);
    }

    @Test
    public void test_3() {
        int[] I0_copy = Arrays.copyOf(I0, I0.length);
        qsort3(I0_copy, 0, I0_copy.length - 1);
        assertArrayEquals(E, I0_copy);
    }

    @Test
    public void test_4() {
        int[] I0_copy = Arrays.copyOf(I0, I0.length);
        qsort4(I0_copy, 0, I0_copy.length - 1);
        assertArrayEquals(E, I0_copy);
    }
}

