package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 18/11/19.
 */
@RunWith(value = JUnit4.class)
public class TestStack extends TestBase {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(true, stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        assertEquals(2, stack.search(3));
        assertEquals(1, stack.search(4));
        assertEquals(false, stack.empty());
        assertEquals(Integer.valueOf(4), stack.peek());
        assertEquals(Integer.valueOf(4), stack.pop());
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(true, stack.empty());
    }

}
