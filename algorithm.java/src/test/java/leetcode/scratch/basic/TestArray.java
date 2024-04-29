package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.stream.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestArray extends TestBase {

    @Test
    public void test_1() {
        int[][] d2a = { {1, 2, 3}, {4, 5, 6} };
        int n = 10000;
        int[][] d2b = new int[n][n];
        // System.out.println(Arrays.toString(d2b[9999]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d2b[i][j] = 1;
            }
        }
    }

    private <T> T[] getArray(String raw, Class<T> c) {
        if (raw.length() == 0) return null;
        String[] splits = raw.split(",");
        Object[] array = null;
        if ("java.lang.Integer".equals(c.getTypeName())) {
            array = Arrays.stream(splits).map(s -> Integer.valueOf(s))
                .toArray(Integer[]::new);
        } else if ("java.lang.Double".equals(c.getTypeName())) {
            array = Arrays.stream(splits).map(s -> Double.valueOf(s))
                .toArray(Double[]::new);
        }
        // cast to type T is correct
        @SuppressWarnings("unchecked")
        T[] r = (T[]) array;
        return r;
    }

    @Test
    public void test_generic() {
        assertArrayEquals(
            new Integer[]{123, 456, 789},
            getArray("123,456,789", Integer.class));
        assertArrayEquals(
            new Double[]{1.1, 1.2, 1.3},
            getArray("1.1,1.2,1.3", Double.class));
    }

    @Test
    public void test_array_len_0() {
        int[] q = new int[0];
        assertEquals(0, q.length);
    }

    @Test
    public void test_Object_reference_to_array() {
        Object a = new int[]{100, 200};
        // assertEquals(a.length, 2); // cannot find symbol
        assertEquals(((int[])a)[0], 100);
    }

    @Test
    public void test_array_init() {
        int[] a = new int[10];
        Arrays.fill(a, -1);
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}, a);
    }

}
