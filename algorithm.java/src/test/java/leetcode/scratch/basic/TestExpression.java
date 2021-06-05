package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import leetcode.TestBase;

/**
 * Created by gpanda on 5/12/17.
 */
@RunWith(value = JUnit4.class)
public class TestExpression extends TestBase {

    @Test
    public void test_1() {
        assertEquals(5, 5 - 5+5);
    }

    @Test
    public void test_ternary() {
        Object a = null;
        Object b = new Object();
        Object c = (a == null) ? null :
            b;
        Object d = (b == null) ? null :
            b;
        assertEquals(null, c);
        assertEquals(b, d);
    }

    @Test
    public void test_subsub() {
        int [] a = {0, 1, 2, 3, 4, 5, 0, 0, 0, 0};
        int m = 6;
        int n = 4;
        int i = m + n - 1;
        while (i >= n) {
            // a[i--] = a[i - n]; // Java doesn't support like C
            a[i] = a[i -n ];
            i--;
            // System.out.println(Arrays.toString(a));
        }
        assertArrayEquals(new int[]{0, 1, 2, 3, 0, 1, 2, 3, 4, 5}, a);
    }
}
