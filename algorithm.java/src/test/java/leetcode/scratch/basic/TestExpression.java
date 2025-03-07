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
    public void test_ternary_2() {
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
    public void test_subsub_3() {
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

    @Test
    public void test_power_4() {
        assertEquals(7, 2^5); // not 32
        assertEquals(32, (int)Math.pow(2, 5));
    }

    @Test
    public void test_assignment_5() {
        int a = 5;
        a -= 1;
        assertEquals(4, a);
        a *= 2;
        assertEquals(8, a);
        a /= 4;
        assertEquals(2, a);
        a *= 3 + 2;
        assertEquals(10, a);
    }

    @Test
    public void test_and_or_xor_6() {
        assertEquals(false, true^true); // xor
        assertEquals(false, false^false); // xor
        assertEquals(true, false^true); // xor
        assertEquals(true, true^false); // xor
        assertEquals(2, 3^1); // xor
        assertEquals(true, true && true); // and
        assertEquals(false, false && false); // and
        assertEquals(false, true && false); // and
        assertEquals(false, false && true); // and
        assertEquals(true, true || true); // or
        assertEquals(true, true || false); // or
        assertEquals(true, false || true); // or
        assertEquals(false, false || false); // or
    }

    @Test
    public void test_self_increment() {
        int[] a = {10, 11, 12, 13, 14};
        int i = 1;
        assertEquals(11, a[i]);
        a[i++]++;
        assertEquals(12, a[1]);
        assertEquals(12, a[2]);

        int[] b = {1, 2, 3, 4, 5};
        int j = 2;
        assertEquals(3, b[j]);
        b[j] = b[j++];          // b[2] = b[2]; j++;
        assertEquals(4, b[j]);
        assertEquals(3, b[2]);
        assertEquals(4, b[3]);
    }
}
