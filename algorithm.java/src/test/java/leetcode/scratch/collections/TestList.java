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
 */
@RunWith(value = JUnit4.class)
public class TestList extends TestBase {

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>(arr.length);
        for (int a : arr) {
            list.add(a);
        }
        Integer[] aRR = list.toArray(new Integer[0]);
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
}
