package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 5/11/17.
 */
@RunWith(value = JUnit4.class)
public class TestModulus extends TestBase {

    @Test
    public void test() {
        // Concrete Mathematics [C.3 Integer functions: 3.1, 3.4]
        // modulus and floor function
        // n = m * ⌊n / m⌋ + n mod m
        // n mod m = n - m * ⌊n / m⌋        for m ≠ 0
        // ⌊-x⌋ = -⌈x⌉, ⌈-x⌉ = -⌊x⌋, e.g. ⌊-0.5⌋ = -1

        // The diff. between Python & Java is the def. of floor function.
        // Python agrees with Concrete Mathematics

        // Python: reminder has the same sign to the divisor and less magnitude
        // than that of the divisor
        // assert([-1, 1] == [-1 / 2, -1 % 2])      1 = -1 - 2 * ⌊-1 / 2⌋
        // assert([-1, 1] == [-3 / 4, -3 % 4])      1 = -3 - 4 * ⌊-3 / 4⌋
        // assert([-2, 2] == [-4 / 3, -4 % 3])      2 = -4 - 3 * ⌊-4 / 3⌋
        // assert([-2, 4] == [-8 / 6, -8 % 6])      4 = -8 - 6 * ⌊-8 / 6⌋

        // assert([-1, -1] == [1 / -2, 1 % -2])     -1 = 1 - -2 * ⌊1 / -2⌋
        // assert([-1, -1] == [3 / -4, 3 % -4])     -1 = 3 - -4 * ⌊3 / -4⌋
        // assert([-2, -2] == [4 / -3, 4 % -3])     -2 = 4 - -3 * ⌊4 / -3⌋
        // assert([-2, -4] == [8 / -6, 8 % -6])     -4 = 8 - -6 * ⌊8 / -6⌋

        // Java: reminder has the same sign to the dividend and less magnitude
        // than that of the divisor
        assertArrayEquals(new int[]{0, -1},  new int[]{-1 / 2, -1 % 2});
        assertArrayEquals(new int[]{0, -3},  new int[]{-3 / 4, -3 % 4});
        assertArrayEquals(new int[]{-1, -1}, new int[]{-4 / 3, -4 % 3});
        assertArrayEquals(new int[]{-1, -2}, new int[]{-8 / 6, -8 % 6});

        assertArrayEquals(new int[]{0, 1},  new int[]{1 / -2, 1 % -2});
        assertArrayEquals(new int[]{0, 3},  new int[]{3 / -4, 3 % -4});
        assertArrayEquals(new int[]{-1, 1}, new int[]{4 / -3, 4 % -3});
        assertArrayEquals(new int[]{-1, 2}, new int[]{8 / -6, 8 % -6});
    }
}
