package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 3/31/17.
 * Updated by gpanda on 5/02/24.
 */
@RunWith(value = JUnit4.class)
public class TestList extends TestBase {

    @Test
    public void test_toArrayOfInteger() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>(arr.length);
        for (int a : arr) {
            list.add(a);
        }
        Integer[] aRR = list.toArray(new Integer[0]);
    }

    @Test
    public void test_toArrayOfInt() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, a);
    }

    @Test
    public void test_1() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(6);
        list.add(7);
        list.add(8);
        list.set(0, Integer.valueOf(3));
        assertEquals(Integer.valueOf(3), list.get(0));
    }

    @Test
    public void test_printList() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        // System.out.println(l); // ok
    }

    @Test
    public void test_set_with_get() {
        List<Integer> l = Arrays.asList(10, 20, 30, 40, 50);
        assertArrayEquals(new Integer[]{10, 20, 30, 40, 50}, l.toArray());
    }
}
