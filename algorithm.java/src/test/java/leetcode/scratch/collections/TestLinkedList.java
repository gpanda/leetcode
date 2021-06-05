package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 8/14/17.
 */
@RunWith(value = JUnit4.class)
public class TestLinkedList extends TestBase {

    @Test
    public void test_1() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(Integer.valueOf(1), list.getFirst());
        assertEquals(Integer.valueOf(4), list.getLast());
    }
}
