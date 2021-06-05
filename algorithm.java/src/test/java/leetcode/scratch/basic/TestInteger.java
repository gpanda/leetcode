package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 5/12/17.
 */
@RunWith(value = JUnit4.class)
public class TestInteger extends TestBase {

    @Test
    public void test() {
        assertEquals(2147483647, Integer.MAX_VALUE);
        assertEquals(-2147483648, Integer.MIN_VALUE);
        assertEquals(4294967295L,
            (long)Integer.MAX_VALUE - (long)Integer.MIN_VALUE);
        Integer c = 1;
        Integer d = Integer.valueOf(1);
        assertEquals(Integer.valueOf(1), c);
        assertEquals(Integer.valueOf(1), d);
        assertEquals(Integer.valueOf(2), ++c);
        assertEquals(Integer.valueOf(1), d++);
        assertEquals(Integer.valueOf(2), c);
        assertEquals(Integer.valueOf(2), d);
        assertEquals(c, d);
        Integer e = Integer.valueOf(100);
        e++;
        e++;
        e++;
        assertEquals(Integer.valueOf(103), e);

        int[] array = new int[] {0, 1};
        Integer p = 1;
        assertEquals(1, array[p]); // Integer instance as array index

    }
}
